package Utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> readInput(String pathString) {
        Path path = Paths.get(pathString);
        try {
            return Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return Collections.emptyList();
    }

    public static List<String[]> splitBy(String pathString,String regex) {
        List<String> list = readInput(pathString);
        return list.stream().map(x -> x.split(regex)).toList();
    }

    public static List<Integer> getColumnAsInt( int index, List<String[]> base) {
        return base.stream().map(x -> Integer.parseInt(x[index])).collect(Collectors.toList());
    }

    public static Integer findALlOccurences(List<Integer> list, int value) {
        return (int)(list.stream().filter(x -> x == value).count());
    }
}

