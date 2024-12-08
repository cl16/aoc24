package org.solution;

import org.helper.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static Integer solve() {
        String input = InputReader.textFileString("data/day3.txt");
        String[] muls = extractMuls(input);
        int total = 0;
        for (int i = 0; i < muls.length; i++) {
            total = total + performMul(muls[i]);
        }
        return total;
    }

    private static String[] extractMuls(String input) {
        return Pattern.compile("mul\\([0-9]+,[0-9]+\\)")
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
}
