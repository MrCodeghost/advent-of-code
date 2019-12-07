package uk.co.codeghost.adventofcode.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * It is a six-digit number.
 * The value is within the range given in your puzzle input.
 * Two adjacent digits are the same (like 22 in 122345).
 * Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
 */
class PasswordCrackerTest {

    /**
     * 111111 meets these criteria (double 11, never decreases).
     * 223450 does not meet these criteria (decreasing pair of digits 50).
     * 123789 does not meet these criteria (no double).
     *
     * Part 2:
     * 111111 no longer meets these criteria.
     * 112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
     * 123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
     * 111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).
     */
    @Test
    void passwordIsValid() {
        PasswordCracker cracker = new PasswordCracker(0, 2000000);
        assertFalse(cracker.passwordIsValid(111111));
        assertFalse(cracker.passwordIsValid(223450));
        assertFalse(cracker.passwordIsValid(123789));
        assertTrue(cracker.passwordIsValid(112233));
        assertFalse(cracker.passwordIsValid(123444));
        assertTrue(cracker.passwordIsValid(111122));
    }
}