package uk.co.codeghost.adventofcode.day4;

public class Day4 {
    public static void main(String[] args) {
        PasswordCracker cracker = new PasswordCracker(183564, 657474);
        System.out.println(cracker.numberOfValidPasswordsInRange());
    }
}
