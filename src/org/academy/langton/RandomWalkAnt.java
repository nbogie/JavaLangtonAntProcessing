package org.academy.langton;

import processing.core.PApplet;

public class RandomWalkAnt extends BaseAnt implements Ant {

    public RandomWalkAnt(PApplet p5, Ground ground, GridPosition startPos) {
        super(p5, ground, startPos);
        myColour = p5.color(0, 255, 0);
    }

    @Override
    public void update() {
        Direction randomDirection = Direction.random();
        moveInDirection(randomDirection);
        ground.cellAt(gridPosition).advanceStateColour();
    }

}
