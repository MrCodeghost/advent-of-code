package uk.co.codeghost.adventofcode.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntcodeComputerTest {

    private IntcodeComputer computer;

    @BeforeEach
    void setUp() {
        computer = new IntcodeComputer();
    }

    @Test
    void process() {
        assertArrayEquals(new int[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50},
                computer.process(new int[]{1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50}));
        assertArrayEquals(new int[]{2, 0, 0, 0, 99}, computer.process(new int[]{1, 0, 0, 0, 99}));
        assertArrayEquals(new int[]{2, 3, 0, 6, 99}, computer.process(new int[]{2, 3, 0, 3, 99}));
        assertArrayEquals(new int[]{2, 4, 4, 5, 99, 9801}, computer.process(new int[]{2, 4, 4, 5, 99, 0}));
        assertArrayEquals(new int[]{30, 1, 1, 4, 2, 5, 6, 0, 99}, computer.process(new int[]{1, 1, 1, 4, 99, 5, 6, 0, 99}));
    }
}