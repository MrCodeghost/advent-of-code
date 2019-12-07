package uk.co.codeghost.adventofcode.day3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Advent of Code Day 3 - https://adventofcode.com/2019/day/3
 */
class GridTest {

    @Test
    void getWireIntersections() {
        Grid grid = new Grid();
        Wire wire1 = grid.runWire(Arrays.asList("R3"));
        Wire wire2 = grid.runWire(Arrays.asList("D1", "R1", "U2", "R1", "D2"));

        assertEquals(new HashSet<Position>(
                Arrays.asList(new Position(1, 0),
                        new Position(2, 0))), grid.getWireIntersections());
    }

    @Test
    void runWires() {
        Grid grid = new Grid();
        Wire wire1 = grid.runWire(Arrays.asList("R3"));
        Wire wire2 = grid.runWire(Arrays.asList("D1", "R1", "U2"));

        assertTrue(grid.getWires().contains(wire1));
        assertTrue(grid.getWires().contains(wire2));
    }

    /**
     * R75,D30,R83,U83,L12,D49,R71,U7,L72
     * U62,R66,U55,R34,D71,R55,D58,R83 = distance 159
     */
    @Test
    void testShortestDistace1() {
        Grid grid = new Grid();
        grid.runWire(Arrays.asList("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"));
        grid.runWire(Arrays.asList("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"));
        assertEquals(159, grid.getShortestDistance());
    }

    /**
     * R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
     * U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 = distance 135
     */
    @Test
    void testShortestDistace2() {
        Grid grid = new Grid();
        grid.runWire(Arrays.asList("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"));
        grid.runWire(Arrays.asList("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"));
        assertEquals(135, grid.getShortestDistance());
    }
}