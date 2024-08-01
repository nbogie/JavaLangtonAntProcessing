package org.academy.langton;

public record GridPosition(int x, int y) {

    /**
     * Creates a new grid position based on the given one and an offset.
     * Does NOT mutate the original position.
     */
    public static GridPosition add(GridPosition original, int x, int y){
        return new GridPosition(original.x + x, original.y + y);
    }

    public GridPosition copy(){
        return new GridPosition(x, y);
    }
}
