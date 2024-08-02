package org.academy.langton;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Ground {

    private List<List<Cell>> rowsOfCells;
    private final PApplet applet;
    /**
     * cell size in pixels for display purposes
     */
    private final int cellSize;

    public Ground(PApplet applet, int numColumns, int numRows, int cellSizeInPixels) {
        this.applet = applet;
        this.rowsOfCells = this.createRowsOfCells(numColumns, numRows);
        this.cellSize = cellSizeInPixels;
        //we could also store numColumns and numRows but these can be derived easily.
    }

    int getCellSize() {
        return this.cellSize;
    }

    /**
     * Returns the number of columns in the land grid.  Not the pixel width.
     */
    int width() {
        return this.rowsOfCells.getFirst().size();
    }

    /**
     * Returns the number of rows in the land grid.  Not the pixel height.
     */
    int height() {
        return this.rowsOfCells.size();
    }

    //private
    List<List<Cell>> createRowsOfCells(int maxColumns, int maxRows) {
        List<List<Cell>> rows = new ArrayList<>();
        for (int y = 0; y < maxRows; y++) {
            List<Cell> row = new ArrayList<>();
            rows.add(row);
            for (int x = 0; x < maxColumns; x++) {
                Cell cell = new Cell(x, y);
                row.add(cell);
            }
        }
        return rows;
    }

    static PixelPosition cellPositionAsPixelPosition(GridPosition cellPos, int cellSize) {
        return new PixelPosition(cellSize * cellPos.x(), cellSize * cellPos.y());
    }

    public static void drawSquareAtGridPosition(GridPosition pos, PApplet applet, int cellSize) {
        PixelPosition pixelPosition = cellPositionAsPixelPosition(pos, cellSize);
        applet.square(pixelPosition.x(), pixelPosition.y(), cellSize);
    }

    void draw() {
        applet.stroke(100);
        for (List<Cell> rowOfCells : rowsOfCells) {
            for (Cell cell : rowOfCells) {
                applet.fill(cell.isActive() ? 40 : 255);
                Ground.drawSquareAtGridPosition(
                        cell.gridPosition(), applet, cellSize);
            }
        }
    }

    Cell cellAt(int x, int y) {
        return rowsOfCells.get(y).get(x);
    }

    Cell cellAt(GridPosition gridPos) {
        return cellAt(gridPos.x(), gridPos.y());
    }

    GridPosition positionOfCentre() {
        return new GridPosition(
                (int) Math.floor(width() / 2.0),
                (int) Math.floor(height() / 2.0));
    }

    void clear() {
        rowsOfCells = createRowsOfCells(width(), height());
    }

    boolean isPositionOutOfBounds(GridPosition pos) {
        return pos.x() < 0 || pos.x() > width() - 1 || pos.y() < 0 || pos.y() > height() - 1;
    }

} //ends the class Land declaration