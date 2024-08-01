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
        this.direction = Direction.random();
        this.ground = ground;
        this.gridPosition = new GridPosition(startPos.x(), startPos.y());
        this.myColour = p5.color(255, 255, 0);
    }

    public void display() {
        p5.fill(myColour);
        Ground.drawSquareAtGridPosition(gridPosition, p5, ground.getCellSize());
    }

    public void update() {
        Cell currentCell = ground.cellAt(gridPosition);

        if (currentCell.isActive()){
            turnClockwise();
        } else {
            turnCounterclockwise();
        }
        currentCell.toggleActive();
        moveForward();
    }

    private void moveForward() {
        DirectionalOffset directionalOffset = DirectionalOffset.offsetFor(direction);
        GridPosition candidatePosition = GridPosition.add(gridPosition, directionalOffset.x(), directionalOffset.y());
        if (ground.isPositionOutOfBounds(candidatePosition)){
            gridPosition = ground.midpoint().copy();
        }
        else {
            gridPosition = candidatePosition;
        }

    }

    private void turnClockwise() {
        direction = direction.nextClockwise();
    }
    private void turnCounterclockwise() {
        direction = direction.nextCounterClockwise();
    }
}
