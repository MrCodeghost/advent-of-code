package uk.co.codeghost.adventofcode.day3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        intersections.remove(new Position(0, 0));
        return intersections;
    }

    public Integer getShortestDistance() {
        return getWireIntersections().stream().map(position -> Math.abs(position.getX())
                + Math.abs(position.getY())).min(Integer::compare).get();
    }
}
