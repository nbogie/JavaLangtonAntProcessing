package org.academy.langton;

public class Cell {
    private boolean isActive;
    private final GridPosition gridPosition;

    public Cell(int x, int y){
        gridPosition = new GridPosition(x, y);
        isActive = false;
    }

    public boolean toggleActive(){
        isActive = !isActive;
        return isActive;
    }

    public void setActive(boolean value){
        isActive = value;
    }

    public boolean isActive() {
        return isActive;
    }

    public GridPosition gridPosition(){
        return gridPosition;
    }
}
