package uk.co.codeghost.adventofcode.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuelCalculatorTest {

    private FuelCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FuelCalculator();
    }

    /**
     * For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
     * For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
     * For a mass of 1969, the fuel required is 654.
     * For a mass of 100756, the fuel required is 33583.
     */
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

    /**
     * A module of mass 14 requires 2 fuel. This fuel requires no further fuel (2 divided by 3 and rounded down is 0,
     * which would call for a negative fuel), so the total fuel required is still just 2.
     *
     * At first, a module of mass 1969 requires 654 fuel. Then, this fuel requires 216 more fuel (654 / 3 - 2).
     * 216 then requires 70 more fuel, which requires 21 fuel, which requires 5 fuel, which requires no further fuel.
     * So, the total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.
     *
     * The fuel required by a module of mass 100756 and its fuel is:
     *      33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.
     */
    @Test
    void calculateWithFuel() {
        assertEquals(2, calculator.calculateIncludingFuel(14l));
        assertEquals(966, calculator.calculateIncludingFuel(1969l));
        assertEquals(50346, calculator.calculateIncludingFuel(100756l));
    }
}