package org.academy.langton;

import processing.core.PApplet;

public class Ant {
    private GridPosition gridPosition;
    private Direction direction;
    private final Ground ground;  //ref won't change once ant is created

    //named "p5" for brevity and familiarity, even though it's not actually p5 but a "Processing Applet" instance.
    private final PApplet p5;

    //there's no real "color" type, it's just stored as an int
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
        displayGridPositionAsText();
    }

    void displayGridPositionAsText() {
        p5.fill(0);
        p5.textSize(20);
        p5.text(gridPosition.toString(), 20, 50);
    }

    public void update() {
        Cell currentCell = ground.cellAt(gridPosition);

        CellColour cellColour = currentCell.getStateColour();
        switch (cellColour) {
            case WHITE -> turnCounterclockwise();
            case BLACK -> turnClockwise();
            case RED -> { /* no turn */ }
        }
        //in all cases...
        currentCell.advanceStateColour();
        moveForward();
    }

    private void moveForward() {
        moveInDirection(direction);
    }

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

    private void turnClockwise() {
        direction = direction.nextClockwise();
    }

    private void turnCounterclockwise() {
        direction = direction.nextCounterClockwise();
    }
}
