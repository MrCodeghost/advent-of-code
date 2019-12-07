package uk.co.codeghost.adventofcode.day3;

import javafx.geometry.Pos;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class Grid {
    @Getter
    private List<Wire> wires = new ArrayList<>();

    public Wire runWire(List<String> instructions) {
        Wire wire = new Wire(instructions);
        wires.add(wire);
        return wire;
    }

    public Set<Position> getWireIntersections() {
        if (wires.size() < 2)
            return null;

        Set<Position> intersections = wires.get(0).getGridPositions();
        for (Wire wire : wires.subList(1, wires.size())) {
            intersections.retainAll(wire.getGridPositions());
        }

        /**
         * The previous step has retained one copy of each Position object that appeared in both lists. However, to
         * calculate the total steps of intersections we need to combine the step count of each Position at an
         * intersection.
         *
         * Note: The Position equals method is overridden to match just based on (x,y) ignoring step variable.
         */
        List<Position> allPositions =
                wires.stream().map(Wire::getGridPositions).flatMap(Collection::stream).collect(Collectors.toList());
        intersections.forEach(position -> {
            int steps = 0;
            for (Position p : allPositions) {
                if (p.equals(position))
                    steps += p.getStep();
            }
            position.setStep(steps);
        });

        intersections.remove(new Position(0, 0, 0));
        return intersections;
    }

    public Integer getShortestDistance() {
        return getWireIntersections().stream().map(position -> Math.abs(position.getX())
                + Math.abs(position.getY())).min(Integer::compare).get();
    }

    public Integer getFewestSteps() {
        return getWireIntersections().stream().map(position -> position.getStep()).min(Integer::compare).get();
    }
}
