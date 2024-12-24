package org.solution;

import org.helper.InputReader;

import java.util.List;

public class Day4 {

    private int count;
    private final List<String> puzzleTextLines;
    private final int numRows;
    private final int numCols;
    private final String target;

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
            ; // path is invalid, out of bounds
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
