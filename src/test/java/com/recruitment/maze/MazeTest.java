package com.recruitment.maze;


import com.recruitment.maze.AppExceptions.ClosedDoorException;
import com.recruitment.maze.AppExceptions.DoorAlreadyClosedException;
import com.recruitment.maze.AppExceptions.IllegalMoveException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MazeTest {

    /**
     * each letter represent a room
     * each | represent a gate between two room
     * each $ represent a gate with a sensor on
     */
    @Test
    public void be_Walkable_Till_The_End() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("E");
        mz.walkTo("F");
        mz.walkTo("G");
    }

    @Test(expected = IllegalMoveException.class)
    public void refuse_Illegal_Move() {
        Maze mz = new Maze("A$B", "A$C", "B$D");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("E"); // room E does not exist in the mz
    }

    @Test(expected = IllegalMoveException.class)
    public void refuse_Move_Without_Path() {
        Maze mz = new Maze("A$B", "A$C", "B$D");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("C"); // Can not reach C from B
    }

    @Test
    public void allow_Cyclic_Path() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("D");
        mz.walkTo("F");
        mz.walkTo("E");
        mz.walkTo("B");
        mz.walkTo("D");
        mz.walkTo("F");
        mz.walkTo("G");
    }


    @Test
    public void allow_Back_And_Forth() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("C");
        mz.walkTo("A");
        mz.walkTo("B");
        mz.walkTo("D");
    }


    @Test
    public void allow_Walker_To_Close_Passed_Door() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("D");
        mz.walkTo("F");
        mz.closeLastDoor();
        mz.walkTo("G");
    }

    @Test(expected = DoorAlreadyClosedException.class)
    public void allow_Walker_To_Close_Only_Last_Door() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("D");
        mz.walkTo("F");
        mz.closeLastDoor();
        mz.closeLastDoor();
        mz.walkTo("G");
    }

    @Test(expected = ClosedDoorException.class)
    public void not_Allow_Closed_Door_Crossing() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("D");
        mz.closeLastDoor();
        mz.walkTo("F");
        mz.walkTo("E");
        mz.walkTo("B");
        mz.walkTo("D");
        mz.walkTo("F");
        mz.walkTo("G");
    }

    @Test(expected = ClosedDoorException.class)
    public void not_Allow_Turn_Back_Through_Closed_Door() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("B");
        mz.walkTo("D");
        mz.closeLastDoor();
        mz.walkTo("B");
    }

    @Test
    public void follow_Walker() {
        Maze mz = new Maze("A$B", "A$C", "B$D", "D$E", "D$F", "F$H", "D$F");
        mz.popIn("A");
        mz.walkTo("B");
        assertThat(mz.readSensors()).isEqualTo("AB");
        mz.walkTo("D");
        assertThat(mz.readSensors()).isEqualTo("AB;BD");
        mz.walkTo("F");
        assertThat(mz.readSensors()).isEqualTo("AB;BD;DF");
    }

    @Test
    public void follow_Walker_Through_Unmonitored_Path() {
        Maze mz = new Maze("A$B", "A$C", "C|E", "B$D", "B|E", "E$F", "D$F", "F|G");
        mz.popIn("A");
        mz.walkTo("B");
        assertThat(mz.readSensors()).isEqualTo("AB");
        mz.walkTo("E");
        mz.walkTo("F");
        assertThat(mz.readSensors()).isEqualTo("AB;EF");
        mz.walkTo("G");
        assertThat(mz.readSensors()).isEqualTo("AB;EF");
    }
}
