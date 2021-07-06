/*
https://leetcode.com/problems/reduce-array-size-to-the-half/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public int minSetSize(int[] arr) {
        if (arr.length < 3)
            return 1;

        Arrays.sort(arr);

        List<Integer> freq = new ArrayList<>();
        freq.add(1);
        int k = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                int element = freq.get(k) + 1;
                if (element >= arr.length / 2)
                    return 1;
                freq.set(k, element);
            } else {
                freq.add(1);
                k++;
            }
        }

        freq.sort(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < freq.size(); i++) {
            sum += freq.get(i);
            if (sum >= arr.length / 2)
                return i + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] arr1 = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(m.minSetSize(arr1));

        int[] arr2 = {7, 7, 7, 7, 7, 7};
        System.out.println(m.minSetSize(arr2));

        int[] arr3 = {1, 9};
        System.out.println(m.minSetSize(arr3));

        int[] arr4 = {1000, 1000, 3, 7};
        System.out.println(m.minSetSize(arr4));

        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(m.minSetSize(arr5));

        int[] arr6 = {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
        System.out.println(m.minSetSize(arr6));
    }
}
