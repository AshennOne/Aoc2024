package Day3;

import java.util.List;

import static Utils.Utils.findAllStringsByRegex;

public class Day3_2 {

    public static void main(String[] args) {
        List<String> x = findAllStringsByRegex("Day3/input.txt", "(mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\))");
        long sum = 0;
        boolean b=  true;
        for (String s : x) {
            if(s.contains("don't")) b = false;
            else if (s.contains("do")) b = true;
            else if(b){
                String[] parts = s.replaceAll("[^\\d-]", " ").trim().split("\\s+");
                sum += Long.parseLong(parts[0]) * Long.parseLong(parts[1]);
            }


        }
        System.out.println(sum);
    }
}
