package org.academy.langton;

import processing.core.PApplet;

public class Ant {
    private float size;
    private GridPosition gridPosition;
    private Direction direction;
    private final Ground ground;

    //named "p5" for brevity and familiarity, even though it's not p5
    private final PApplet p5;

    //there's no real color type, it's just stored as an int
    private final int myColour;

    public Ant(PApplet p5, Ground ground, GridPosition startPos) {
        this.p5 = p5;
        this.ground = ground;
        this.gridPosition = new GridPosition(startPos.x(), startPos.y());
        this.myColour = p5.color(p5.random(0, 255), p5.random(0, 255), p5.random(0, 255));
    }

    public void display() {
        p5.fill(myColour);
        int cellSize = ground.getCellSize();
        int x = cellSize * gridPosition.x();
        int y = cellSize * gridPosition.y();
        p5.square(x, y, cellSize);
    }

    public void update() {
        int xMovement = Math.random() < 0.5 ? 1 : -1;
        int yMovement = Math.random() < 0.5 ? 1 : -1;

        gridPosition = GridPosition.add(gridPosition, xMovement, yMovement);
        if (ground.isPositionOutOfBounds(gridPosition)){
            gridPosition = ground.midpoint().copy();
        }
    }
}
