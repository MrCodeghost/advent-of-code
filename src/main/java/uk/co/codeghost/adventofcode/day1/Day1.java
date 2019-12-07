package uk.co.codeghost.adventofcode.day1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Day1 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/uk.co.codeghost.adventofcode.day1/input.txt")) {
            List<Long> moduleMasses = IOUtils.readLines(fis, "UTF-8").stream().map(
                    line -> Long.valueOf(line)).collect(Collectors.toList());
            System.out.println("Required fuel not including fuel: " + new FuelCalculator().calculateForModules(moduleMasses));
            System.out.println("Required fuel including fuel: " + new FuelCalculator().calculateForModulesInlcudingFuel(moduleMasses));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
