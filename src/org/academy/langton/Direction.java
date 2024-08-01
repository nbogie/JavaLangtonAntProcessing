package org.academy.langton;

import java.util.Random;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static final Random RANDOM = new Random();

    public static Direction random() {
        int index = RANDOM.nextInt(Direction.values().length);
        return Direction.values()[index];
    }

    public Direction nextClockwise() {
        return switch (this) {
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
            case NORTH -> Direction.EAST;
        };
    }

    public Direction nextCounterClockwise() {
        return switch (this) {
            case EAST -> Direction.NORTH;
            case NORTH -> Direction.WEST;
            case WEST -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
        };
    }
}
