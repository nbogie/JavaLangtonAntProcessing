package org.academy.langton;

import processing.core.PApplet;

public class TeleportingAnt implements Ant {
    private GridPosition gridPosition;
    private final PApplet p5;
    private final Ground ground;


    public TeleportingAnt(PApplet applet, Ground ground, GridPosition startPos) {
        this.gridPosition = startPos.copy();
        this.ground = ground;
        p5 = applet;
    }


    @Override
    public void update() {
        if (Math.random() < 0.1) {

            int x = (int) p5.random(0, ground.width());
            int y = (int) p5.random(0, ground.height());
            gridPosition = new GridPosition(x, y);
        }
    }

    @Override
    public void display() {
        p5.fill(0, 255, 255);
        Ground.drawSquareAtGridPosition(
                gridPosition,
                p5,
                ground.getCellSize()
        );
    }

    @Override
    public GridPosition getGridPosition() {
        return gridPosition.copy();
    }
}
