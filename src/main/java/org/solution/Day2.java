package org.solution;

import org.helper.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static Integer solve() {

        List<String> input = InputReader.textFile("data/day2.txt");
        List<List<Integer>> reports = extractReports(input);
        int safeReports = 0;
        List<Integer> report;

        for (int i = 0; i < reports.size(); i++) {
            report = reports.get(i);
            if (report.size() <= 2) {
                safeReports++;
                continue;
            }

            boolean increasing = true;
            int prev, dif, absDif, curr;
            prev = report.get(0);

            for (int j = 1; j < report.size(); j++) {

                curr = report.get(j);
                dif = prev - curr;
                absDif = Math.abs(dif);

                if ((absDif < 1) || (absDif > 3)) {
                    break;
                }

                if (j == 1) {

                    if (dif > 0) {
                        increasing = false;
                    }
                } else {

                    if ((increasing && (dif > 0) || (!increasing && (dif < 0)))) {
                        break;
                    }

                    if (j == (report.size() - 1)) {
                        safeReports++;
                    }
                }

                prev = report.get(j);
            }
        }

        return safeReports;
    }

    private static List<List<Integer>> extractReports(List<String> input) {
        List<List<Integer>> reports = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String reportString = input.get(i);
            String[] reportList = reportString.split(" ");
            List<Integer> report = new ArrayList<>();
            for (int j = 0; j < reportList.length; j++) {
                report.add(Integer.parseInt(reportList[j]));
            }
            reports.add(report);
        }
        return reports;
    }
}
