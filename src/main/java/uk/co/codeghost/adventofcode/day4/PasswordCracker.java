package uk.co.codeghost.adventofcode.day4;

import java.util.ArrayList;
import java.util.List;

public class PasswordCracker {

    private final int bottomLimit;
    private final int topLimit;

    public PasswordCracker(int bottomLimit, int topLimit) {
        this.bottomLimit = bottomLimit;
        this.topLimit = topLimit;
    }

    /**
     * It is a six-digit number.
     * The value is within the range given in your puzzle input.
     * Two adjacent digits are the same (like 22 in 122345).
     * Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
     *
     * @param password
     * @return
     */
    boolean passwordIsValid(int password) {
        String passwordString = String.valueOf(password);

        if (passwordString.length() != 6)
            return false;

        if (password < bottomLimit || password > topLimit)
            return false;

        boolean twoAdjacentDigits = false;
        for (int i = 0; i < passwordString.length() - 1; i++) {
            if (passwordString.charAt(i) == passwordString.charAt(i + 1))
                twoAdjacentDigits = true;
        }
        if (!twoAdjacentDigits)
            return false;

        for (int i = 0; i < passwordString.length() - 1; i++) {
            if(passwordString.charAt(i+1)<passwordString.charAt(i))
                return false;
        }

        return true;
    }

    public List<Integer> getPossiblePasswordsInRange() {
        List<Integer> passwords = new ArrayList<>();
        for(int i = bottomLimit; i<=topLimit; i++) {
            if(passwordIsValid(i))
                passwords.add(i);
        }
        return passwords;
    }

    public int numberOfValidPasswordsInRange() {
        return getPossiblePasswordsInRange().size();
    }
}
