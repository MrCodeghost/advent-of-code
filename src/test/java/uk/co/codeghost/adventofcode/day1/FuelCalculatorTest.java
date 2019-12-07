package uk.co.codeghost.adventofcode.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
 * For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
 * For a mass of 1969, the fuel required is 654.
 * For a mass of 100756, the fuel required is 33583.
 */
class FuelCalculatorTest {

    private FuelCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FuelCalculator();
    }

    @Test
    void calculate() {
        assertEquals(2, calculator.calculate(12l));
        assertEquals(2, calculator.calculate(14l));
        assertEquals(654, calculator.calculate(1969l));
        assertEquals(33583, calculator.calculate(100756l));
    }

    @Test
    void calculateMassOfModuleList() {
        assertEquals(33583 + 654 + 2 + 2, calculator.calculateForModules(Arrays.asList(12l, 14l, 1969l, 100756l)));
    }
}