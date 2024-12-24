package org.solution;

import org.helper.InputReader;
import org.helper.XYCoordinates;

import java.util.List;

public class Day4 {

    /** Notes on approach:
     *
     * Convert the puzzle text into a singular string with an integer representing the index of each character.
     *
     * For each "X" root of "XMAS", call 8 recursive functions that branch out in each of the 8 directions an
     * XMAS string can go in.
     *
     * Recursive function will keep track of which character of XMAS it is checking for at a given index, and will
     * keep track of whether it has gone "out of bounds".
     *
     * Use integer division and modulus to determine row/column of each integer for boundary navigation.
     *
     * OR...
     *
     * Can use X,Y coordinates and each trace in each direction can be broken into a pair of X-shift, Y-shift, where
     * the X/Y shift can be easily determined to be out-of-bounds if in the first row (no Y+1), right-most column
     * (no X+1), etc...
     *
     * Can index into the 2-D array of characters with X/Y indices easily too, instead of one long string...
     */

    private int count;
    private List<String> puzzleTextLines;
    private int numRows;
    private int numCols;
    private String puzzleText;
    private String target;

    public Day4() {
        count = 0;
        puzzleTextLines = InputReader.textFileLines("data/day4.txt");
        numRows = puzzleTextLines.size();
        numCols = puzzleTextLines.getFirst().length();
        target = "XMAS";
    }

    public Integer solve() {
        for (int y = 0; y < this.numRows; y++) {
            for (int x = 0; x < this.numCols; x++) {
                if (this.puzzleTextLines.get(y).charAt((x)) == 'X') {
                    branchPaths(x, y);
                }
            }
        }
        return this.count;
    }

    private boolean validTargetLetter(int x, int y, int wordIndex) {
        char puzzleLetter = this.puzzleTextLines.get(y).charAt(x);
        char targetLetter = this.target.charAt(wordIndex);
        return puzzleLetter == targetLetter;
    }

    private void evaluatePath(int x, int y, int xShift, int yShift, int wordIndex) {
        x = x + xShift;
        y = y + yShift;
        if ((x < 0) || (x == this.numCols) || (y < 0) || (y == this.numRows)) {
            ;
        }
        else if (wordIndex == (this.target.length() - 1)) {
            if (validTargetLetter(x, y, wordIndex)) {
                this.count++;
            };
        }
        else if (validTargetLetter(x, y, wordIndex)) {
            evaluatePath(x, y, xShift, yShift, wordIndex + 1);
        }
    };

    private void branchPaths(int x, int y) {
        evaluatePath(x, y, -1, 1, 1);
        evaluatePath(x, y, -1, 0, 1);
        evaluatePath(x, y, -1, -1, 1);
        evaluatePath(x, y, 0, 1, 1);
        evaluatePath(x, y, 0, -1, 1);
        evaluatePath(x, y, 1, 1, 1);
        evaluatePath(x, y, 1, 0, 1);
        evaluatePath(x, y, 1, -1, 1);
    }


}
