package Day3;

import java.util.List;

import static Utils.Utils.findAllStringsByRegex;

public class Day3_1 {

    public static void main(String[] args) {
        List<String> x = findAllStringsByRegex("Day3/input.txt", "mul\\(\\d+,\\d+\\)");
        long sum = 0;
        for (String s : x) {
            String[] parts = s.replaceAll("[^\\d-]", " ").trim().split("\\s+");
            sum += Long.parseLong(parts[0]) * Long.parseLong(parts[1]);

        }
        System.out.println(sum);
    }
}
