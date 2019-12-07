package uk.co.codeghost.adventofcode.day2;

import lombok.extern.slf4j.Slf4j;

/**
 * Once you have a working computer, the first step is to restore the gravity assist program (your puzzle input)
 * to the "1202 program alarm" state it had just before the last computer caught fire. To do this, before running the
 * program, replace position 1 with the value 12 and replace position 2 with the value 2.
 *
 * What value is left at position 0 after the program halts?
 */
@Slf4j
public class Day2 {
    private static int[] PROGRAM = new int[]{1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 9, 1, 19, 1, 19, 6, 23, 2, 6, 23, 27, 2, 27, 9, 31, 1, 5, 31, 35, 1, 35, 10, 39, 2, 39, 9, 43, 1, 5, 43, 47, 2, 47, 10, 51, 1, 51, 6, 55, 1, 5, 55, 59, 2, 6, 59, 63, 2, 63, 6, 67, 1, 5, 67, 71, 1, 71, 9, 75, 2, 75, 10, 79, 1, 79, 5, 83, 1, 10, 83, 87, 1, 5, 87, 91, 2, 13, 91, 95, 1, 95, 10, 99, 2, 99, 13, 103, 1, 103, 5, 107, 1, 107, 13, 111, 2, 111, 9, 115, 1, 6, 115, 119, 2, 119, 6, 123, 1, 123, 6, 127, 1, 127, 9, 131, 1, 6, 131, 135, 1, 135, 2, 139, 1, 139, 10, 0, 99, 2, 0, 14, 0};

    public static void main(String[] args) {
        IntcodeComputer computer = new IntcodeComputer();
        PROGRAM[1] = 12;
        PROGRAM[2] = 2;

        System.out.println(computer.process(PROGRAM)[0]);
    }
}
