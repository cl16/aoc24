package org.solution;

import org.helper.InputReader;
import org.helper.Sorter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {

    public static Integer solution() {
        List<String> input;
        try {
            input = InputReader.textFile("data/day1.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            String row = input.get(i);
            String[] rowSplit = row.split("   ");
            listA.add(Integer.parseInt(rowSplit[0]));
            listB.add(Integer.parseInt(rowSplit[1]));
        }

        List<Integer> sortedA = Sorter.quickSort(listA);
        List<Integer> sortedB = Sorter.quickSort(listB);

        int total = 0;
        for (int i = 0; i < sortedA.size(); i++) {
            int dif =  Math.abs(sortedA.get(i) - sortedB.get(i));
            total = total + dif;
        }
        return total;
    }
}
