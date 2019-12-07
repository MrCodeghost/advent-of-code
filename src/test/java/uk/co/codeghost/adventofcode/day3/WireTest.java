package uk.co.codeghost.adventofcode.day3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WireTest {

    @Test
    public void testUpInstructions() {
        Wire wire = new Wire(Arrays.asList("U3"));
        assertEquals(new HashSet<Position>(Arrays.asList(new Position(0, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3))), wire.getGridPositions());
    }

    @Test
    public void testDownInstructions() {
        Wire wire = new Wire(Arrays.asList("D3"));
        assertEquals(new HashSet<Position>(Arrays.asList(new Position(0, 0),
                new Position(0, -1),
                new Position(0, -2),
                new Position(0, -3))), wire.getGridPositions());
    }

    @Test
    public void testLeftInstructions() {
        Wire wire = new Wire(Arrays.asList("L3"));
        assertEquals(new HashSet<Position>(Arrays.asList(new Position(0, 0),
                new Position(-1, 0),
                new Position(-2, 0),
                new Position(-3, 0))), wire.getGridPositions());
    }

    @Test
    public void testRightInstructions() {
        Wire wire = new Wire(Arrays.asList("R3"));
        assertEquals(new HashSet<Position>(Arrays.asList(new Position(0, 0),
                new Position(1, 0),
                new Position(2, 0),
                new Position(3, 0))), wire.getGridPositions());
    }

    @Test
    public void testSquareInstructions() {
        Wire wire = new Wire(Arrays.asList("R3", "U3", "L3", "D3"));
        assertEquals(new HashSet<Position>(Arrays.asList(new Position(0, 0),
                new Position(1, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 3),
                new Position(2, 3),
                new Position(1, 3),
                new Position(0, 3),
                new Position(0, 2),
                new Position(0, 1),
                new Position(0, 0))), wire.getGridPositions());
    }
}