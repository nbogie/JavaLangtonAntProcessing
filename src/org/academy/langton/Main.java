package org.academy.langton;

import processing.core.PApplet;

//TODO: remove this javascript implementation link
//https://openprocessing.org/sketch/2248058
public class Main extends PApplet {
    private Ant ant1;
    private Ant ant2;
    private Ground ground;
    private final int pixelWidth = 800;
    private final int pixelHeight = 800;

    public static void main(String[] args) {
        PApplet.main(new String[]{"org.academy.langton.Main"});
    }

    @Override
    public void settings() {
        size(pixelWidth, pixelHeight);
    }

    @Override
    public void setup() {
        int cellSize = 20;
        int numColumns = pixelWidth / cellSize;
        int numRows = pixelHeight / cellSize;
        ground = new Ground(this, numColumns, numRows, cellSize);

        //where to start our ant?
        GridPosition startPos = new GridPosition(numColumns / 2, numRows / 2);

        ant1 = new Ant(this, ground, startPos);
        ant2 = new Ant(this, ground, new GridPosition(10, 10));
        //frameRate(20);
    }

    public void keyPressed(){
        if (key=='c'){
            ground.clear();
        }
        if (key=='m') {
            GridPosition desiredPosition = new GridPosition(15, 6);
            ant1.reposition(desiredPosition);
        }
    }

    @Override
    public void draw() {
        background(200);
        ground.draw();

        ant1.display();
        ant1.update();

        ant2.display();
        ant2.update();
    }
}