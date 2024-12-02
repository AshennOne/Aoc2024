package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utils.Utils.splitBy;

public class Day2_2 {
    public static void main(String[] args) {
        var input = splitBy("Day2/input.txt", " ");
        List<List<Integer>> reports = new ArrayList<>();
        for (var line : input) {
            List<Integer> report = new ArrayList<>();
            for (var number : line) {
                report.add(Integer.parseInt(number));
            }
            reports.add(report);
        }

        int safeReports = countSafeDampened(reports);
        System.out.println("Number of safe reports: " + safeReports);
    }

    public static int countSafeDampened(List<List<Integer>> reports) {
        int count = 0;

        for (List<Integer> report : reports) {
            if (isReportSafe(report)) {
                count++;
            } else {
                for (int i = 0; i < report.size(); i++) {
                    List<Integer> reducedReport = new ArrayList<>(report);
                    reducedReport.remove(i);

                    if (isReportSafe(reducedReport)) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isReportSafe(List<Integer> report) {
        if (report.size() < 2) return true;

        boolean increasing = report.get(1) > report.get(0);

        for (int i = 1; i < report.size(); i++) {
            int diff = report.get(i) - report.get(i - 1);

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            if ((increasing && diff < 0) || (!increasing && diff > 0)) {
                return false;
            }
        }

        return true;
    }
}

