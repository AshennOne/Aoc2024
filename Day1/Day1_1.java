package Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utils.Utils.*;

public class Day1_1 {
    public static void main(String[] args) {
        List<String[]> input = splitBy("Day1/input.txt", "   ");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1= getColumnAsInt(0, input);
        list2= getColumnAsInt(1, input);
        Collections.sort(list1);
        Collections.sort(list2);
        Integer sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(sum);
    }

}

