package org.academy.langton;
import processing.core.PApplet;

public class BaseAnt implements Ant{
    protected GridPosition gridPosition;
    protected Direction direction;
    protected final Ground ground;  //ref won't change once ant is created

    //named "p5" for brevity and familiarity, even though it's not actually p5 but a "Processing Applet" instance.
    protected final PApplet p5;

    //there's no real "color" type, it's just stored as an int
    protected int myColour;


    public BaseAnt(PApplet p5, Ground ground, GridPosition startPos) {
        this.p5 = p5;
        this.direction = Direction.random();
        this.ground = ground;
        this.gridPosition = new GridPosition(startPos.x(), startPos.y());
        this.myColour = p5.color(255, 255, 0);
    }

    @Override
    public void update() {
        //do nothing as a base implementation of update
    }

    @Override
    public void display() {
        p5.fill(myColour);
        Ground.drawSquareAtGridPosition(gridPosition, p5, ground.getCellSize());
    }

    @Override
    public GridPosition getGridPosition() {
        return gridPosition.copy();
    }


    protected void moveForward() {
        moveInDirection(direction);
    }

    protected void moveInDirection(Direction givenDir) {
        DirectionalOffset offset = DirectionalOffset.offsetFor(givenDir);
        GridPosition candidatePosition = GridPosition.add(
                gridPosition, offset.x(), offset.y());
        if (ground.isPositionOutOfBounds(candidatePosition)) {
            gridPosition = ground.getCentreGridPosition().copy();
        } else {
            gridPosition = candidatePosition;
        }
    }

    protected void turnClockwise() {
        direction = direction.nextClockwise();
    }

    protected void turnCounterclockwise() {
        direction = direction.nextCounterClockwise();
    }
}
