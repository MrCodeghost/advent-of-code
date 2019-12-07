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
     */
    @Test
    void passwordIsValid() {
        PasswordCracker cracker = new PasswordCracker(0, 2000000);
        assertTrue(cracker.passwordIsValid(111111));
        assertFalse(cracker.passwordIsValid(223450));
        assertFalse(cracker.passwordIsValid(123789));
    }
}