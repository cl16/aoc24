package org.solution;

import org.helper.InputReader;

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

    }

    private void traceWord(int currIdx, int offset, int wordIdx) {
        int nextIdx = currIdx + offset;
        if (this.puzzleText.charAt(nextIdx) == this.target.charAt(wordIdx)) {
            if (wordIdx == (this.target.length() - 1)) {
                this.count++;
            }
            else {
                traceWord(nextIdx, offset, wordIdx++);
            }
        }
    }

    private boolean inBounds(int currIdx, int offset) {
        // determine whether the direction of the offset can be followed based on the currIdx position in the puzzle grid
        int row = Math.floorDiv(currIdx, this.numCols);
        int col = currIdx % this.numCols;

        if ((currIdx + offset) < 0) {
            return false;
        }
        if ((currIdx + offset) > (this.numCols - 1)) {
            return false;
        }

    }
}
