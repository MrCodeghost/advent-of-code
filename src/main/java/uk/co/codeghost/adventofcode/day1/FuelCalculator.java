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
     * Calaculate sum of module masses.
     *
     * @param massOfModules
     * @return
     */
    Long calculateForModules(List<Long> massOfModules) {
        return massOfModules.stream().map(mass -> calculate(mass)).collect(
                Collectors.summarizingLong(Long::longValue)).getSum();
    }
}
