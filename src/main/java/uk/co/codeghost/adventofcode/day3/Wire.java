package uk.co.codeghost.adventofcode.day3;

import javafx.geometry.Pos;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wire {
    @Getter
    private final Set<Position> gridPositions;

    public Wire(List<String> instructions) {
        gridPositions = new HashSet<>();

        Position currentPosition = new Position(0, 0);
        for (String instructionString : instructions) {
            Instruction instruction = Instruction.valueOf(instructionString.substring(0, 1));
            gridPositions.addAll(instruction.followInstruction(currentPosition,
                    Integer.valueOf(instructionString.substring(1, instructionString.length()))));
            currentPosition = instruction.getCurrentPosition();
        };
    }

    enum Instruction {
        U {
            @Override
            Set<Position> followInstruction(Position startingPosition, int distance) {
                Set<Position> postitions = new HashSet<>();
                for (int y = startingPosition.getY(); y <= (startingPosition.getY() + distance); y++) {
                    Position newPosition = new Position(startingPosition.getX(), y);
                    postitions.add(newPosition);
                    currentPosition = newPosition;
                }
                return postitions;
            }
        },
        D {
            @Override
            Set<Position> followInstruction(Position startingPosition, int distance) {
                Set<Position> postitions = new HashSet<>();
                for (int y = startingPosition.getY(); y >= (startingPosition.getY() - distance); y--) {
                    Position newPosition = new Position(startingPosition.getX(), y);
                    postitions.add(newPosition);
                    currentPosition = newPosition;
                }
                return postitions;
            }
        },
        L {
            @Override
            Set<Position> followInstruction(Position startingPosition, int distance) {
                Set<Position> postitions = new HashSet<>();
                for (int x = startingPosition.getX(); x >= (startingPosition.getX() - distance); x--) {
                    Position newPosition = new Position(x, startingPosition.getY());
                    postitions.add(newPosition);
                    currentPosition = newPosition;
                }
                return postitions;
            }
        },
        R {
            @Override
            Set<Position> followInstruction(Position startingPosition, int distance) {
                Set<Position> postitions = new HashSet<>();
                for (int x = startingPosition.getX(); x <= (startingPosition.getX() + distance); x++) {
                    Position newPosition = new Position(x, startingPosition.getY());
                    postitions.add(newPosition);
                    currentPosition = newPosition;
                }
                return postitions;
            }
        };

        @Getter
        Position currentPosition;

        abstract Set<Position> followInstruction(Position startingPosition, int distance);
    }
}
