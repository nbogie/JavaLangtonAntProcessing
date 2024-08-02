package org.academy.langton;

public class Cell {
    private CellColour cellColour;
    private final GridPosition gridPosition;

    public Cell(int x, int y) {
        gridPosition = new GridPosition(x, y);
        cellColour = CellColour.WHITE;
    }

    /**
     * moves the cell's state (colour) onwards through the cycle (updating the cell), and for convenience also returns the new value
     */
    public CellColour advanceStateColour() {
        cellColour = switch (cellColour) {
            case WHITE -> CellColour.BLACK;
            case BLACK -> CellColour.RED;
            case RED -> CellColour.WHITE;
        };
        return cellColour;
    }

    public GridPosition gridPosition() {
        return gridPosition;
    }

    public CellColour getStateColour() {
        return cellColour;
    }

}
