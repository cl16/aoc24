package org.solution;

import org.helper.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static Integer solve() {
        return solvePartTwo();
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

    private static Integer solvePartOne() {
        List<String> input = InputReader.textFileLines("data/day2.txt");
        List<List<Integer>> reports = extractReports(input);
        int safeReports = 0;
        List<Integer> report;
        for (int i = 0; i < reports.size(); i++) {
            report = reports.get(i);
            if (safeReport(report)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    private static Integer solvePartTwo() {
        List<String> input = InputReader.textFileLines("data/day2.txt");
        List<List<Integer>> reports = extractReports(input);
        int safeReports = 0;
        List<Integer> report;
        for (int i = 0; i < reports.size(); i++) {
            report = reports.get(i);
            if (safeReportWithBadLevel(report)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    private static boolean safeReport(List<Integer> report) {
        int prev, dif, absDif, curr;
        prev = report.get(0);
        boolean increasing = true;
        for (int j = 1; j < report.size(); j++) {
            curr = report.get(j);
            dif = prev - curr;
            absDif = Math.abs(dif);
            if ((absDif < 1) || (absDif > 3)) {
                return false;
            }
            if (j == 1) {
                if (dif > 0) {
                    increasing = false;
                }
            } else {
                if ((increasing && (dif > 0) || (!increasing && (dif < 0)))) {
                    return false;
                }
                if (j == (report.size() - 1)) {
                    return true;
                }
            }
            prev = report.get(j);
        }
        return false;
    }

    private static boolean safeReportWithBadLevel(List<Integer> report) {
        if (safeReport(report)) {
            return true;
        }
        else return safeReportIfRemoved(report);
    }

    private static boolean safeReportIfRemoved(List<Integer> report) {
        List<Integer> reducedReport;
        for (int x = 0; x < report.size(); x++) {
            reducedReport = new ArrayList<Integer>(report);
            reducedReport.remove(x);
            if (safeReport(reducedReport)) {
                return true;
            }
        }
        return false;
    }
}
