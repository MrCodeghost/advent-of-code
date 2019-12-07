package uk.co.codeghost.adventofcode.day1;

import java.util.List;
import java.util.stream.Collectors;

public class FuelCalculator {
    /**
     * Fuel required to launch a given module is based on its mass.
     * Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
     *
     * @param mass
     * @return
     */
    Long calculate(Long mass) {
        return ((Long) (mass / 3)) - 2;
    }

    /**
     * Fuel itself requires fuel just like a module - take its mass, divide by three, round down, and subtract 2.
     * However, that fuel also requires fuel, and that fuel requires fuel, and so on. Any mass that would require
     * negative fuel should instead be treated as if it requires zero fuel; the remaining mass, if any, is instead
     * handled by wishing really hard, which has no mass and is outside the scope of this calculation.
     *
     * @param mass
     * @return
     */
    Long calculateIncludingFuel(Long mass) {
        if (calculate(mass) <= 0) {
            return 0l;
        } else {
            return calculate(mass) + calculateIncludingFuel(calculate(mass));
        }
    }

    /**
     * Calaculate sum of module masses.
     *
     * @param massOfModules
     * @return
     */
    Long calculateForModules(List<Long> massOfModules) {
        return massOfModules.stream().map(mass -> calculate(mass)).collect(
                Collectors.summarizingLong(Long::longValue)).getSum();
    }

    /**
     * Calaculate sum of module masses accounting for mass of fuel.
     *
     * @param massOfModules
     * @return
     */
    Long calculateForModulesInlcudingFuel(List<Long> massOfModules) {
        return massOfModules.stream().map(mass -> calculateIncludingFuel(mass)).collect(
                Collectors.summarizingLong(Long::longValue)).getSum();
    }
}
