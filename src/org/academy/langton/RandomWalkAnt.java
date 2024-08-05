package org.academy.langton;

import processing.core.PApplet;

public class RandomWalkAnt implements Ant {
    GridPosition gridPosition;
    Ground ground;
    PApplet p5;

    public RandomWalkAnt(PApplet p5, Ground ground, GridPosition startPos) {
        this.ground = ground;
        gridPosition = startPos.copy();
        this.p5 = p5;
    }


    @Override
    public void update() {
        Direction randomDirection = Direction.random();
        moveInDirection(randomDirection);

        ground.cellAt(gridPosition).advanceStateColour();
    }

    @Override
    public void display() {
        p5.fill(0, 255, 0);
        Ground.drawSquareAtGridPosition(gridPosition, p5, ground.getCellSize());
    }

    //TODO: Share this common code between Tricolour ant and RandomWalk ant.
    private void moveInDirection(Direction givenDir) {
        DirectionalOffset offset = DirectionalOffset.offsetFor(givenDir);
        GridPosition candidatePosition = GridPosition.add(
                gridPosition, offset.x(), offset.y());
        if (ground.isPositionOutOfBounds(candidatePosition)) {
            gridPosition = ground.midpoint().copy();
        } else {
            gridPosition = candidatePosition;
        }
    }

    @Override
    public GridPosition getGridPosition() {
        return gridPosition;
    }
}
