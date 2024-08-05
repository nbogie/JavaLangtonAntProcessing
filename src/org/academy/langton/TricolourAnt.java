package org.academy.langton;

import processing.core.PApplet;

public class TricolourAnt  extends BaseAnt  implements Ant {

    public TricolourAnt(PApplet p5, Ground ground, GridPosition startPos) {
        super(p5, ground, startPos);
        myColour = p5.color(0, 0, 255);
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

}
