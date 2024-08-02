# Kata

## Running the program

Run the main method in Main.java


## Task 1

Implement the update method of the Ant class so that it moves around following the rules in Langton's Ant, as [written up on wikipedia](https://en.wikipedia.org/wiki/Langton%27s_ant) or in this [CodingDojo write-up](https://codingdojo.org/kata/LangtonAnt/)
Note that many useful functions that allow the ant to moveForward() or turnClockwise() are already written up.

See Important objects section below for some help.

## Task 2 - one new colour

In a new branch, update the system to follow the three-colour rules specified in the "One New Colour" section at the end of the [CodingDojo write-up](https://codingdojo.org/kata/LangtonAnt/)

## Important objects (for both tasks)

**Ant**: An Ant object stands on a Ground object representing the entire grid.

**Ground**: A Ground object maintains a list of Cell objects at different positions.

**Cell**: Each Cell knows whether it is active or inactive.

**Colours of cells**: _Active_ cells are drawn black during visualisation, and _inactive_ cells are drawn white, though you could change this.

**PApplet**: Various of the objects have access to a PApplet object - this represents the Processing library and the canvas, and gives access to a lot of drawing methods, as well as others like random(), map(), width(), height(), etc.


## Misc other info

You can speed up the animation by changing the argument to `frameRate()` when it is called in `setup()` in the `Main` class.