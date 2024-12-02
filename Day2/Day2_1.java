package Day2;

import static Utils.Utils.splitBy;

public class Day2_1 {
    public static void main(String[] args) {
        var input = splitBy("Day2/input.txt", " ");
        int sum = 0;
        for(int i = 0; i<input.size(); i++) {
            int[] arr = new int[input.get(i).length];
            for(int j = 0; j < input.get(i).length; j++) {
                arr[j] = Integer.parseInt(input.get(i)[j]);
            }
            if(sorted(arr) && diffMax3(arr)) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    static boolean diffMax3(int[] arr) {
        int diff = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            diff = Math.abs(arr[i] - arr[i + 1]);
            if(diff > 3) return false;
        }
        return true;
    }

    static boolean sorted(int[] arr) {
        boolean ascending = false;
        if(arr[0] < arr[1]) ascending = true;
        for(int i = 0; i < arr.length-1; i++) {
            if(ascending){
                if(arr[i] >= arr[i + 1]) return false;
            } else {
                if(arr[i] <= arr[i + 1]) return false;
            }
        }
        return true;
    }
}
