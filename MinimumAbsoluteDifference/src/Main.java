/*
https://leetcode.com/problems/minimum-absolute-difference/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = 10000001;

        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(Math.abs(arr[i + 1] - arr[i]), min);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) == min) {
                ans.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] arr1 = new int[]{4, 2, 1, 3};
        System.out.println(m.minimumAbsDifference(arr1));
    }
}
