package org.solution;

import org.helper.InputReader;

import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static Integer solve() {
        return solvePartTwo();
    }

    private static String getInput() {
        return InputReader.textFileString("data/day3.txt");
    }

    private static String[] extractInstructions(String input, String pattern) {
        return Pattern.compile(pattern)
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }

    private static int performMul(String mulString) {
        Pattern pattern = Pattern.compile("mul\\(([0-9]+),([0-9]+)\\)");
        Matcher matcher = pattern.matcher(mulString);
        matcher.find();
        return Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
    }

    private static Integer solvePartOne() {
        String input = getInput();
        String[] muls = extractInstructions(input, "mul\\([0-9]+,[0-9]+\\)");
        int total = 0;
        for (int i = 0; i < muls.length; i++) {
            total = total + performMul(muls[i]);
        }
        return total;
    }

    private static Integer solvePartTwo() {
        String input = getInput();
        String[] instructions = extractInstructions(input, "mul\\([0-9]+,[0-9]+\\)|do\\(\\)|don't\\(\\)");
        int total = 0;
        boolean enabled = true;
        String instruction;
        for (int i = 0; i < instructions.length; i++) {
            instruction = instructions[i];
            if (Objects.equals(instruction, "do()")) {
                enabled = true;
            }
            else if (Objects.equals(instruction, "don't()")) {
                enabled = false;
            }
            else if (enabled) {
                total = total + performMul(instruction);
            }
        }
        return total;
    }
}
