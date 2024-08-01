package org.academy.langton;

public record DirectionalOffset(int x, int y){

    public static DirectionalOffset offsetFor(Direction dir){
        return switch (dir) {
            case NORTH -> new DirectionalOffset(0, -1);
            case EAST -> new DirectionalOffset(1, 0);
            case SOUTH -> new DirectionalOffset(0, 1);
            case WEST -> new DirectionalOffset(-1, 0);
        };
    }
}

