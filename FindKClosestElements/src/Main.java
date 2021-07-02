/*
https://leetcode.com/problems/find-k-closest-elements/
 */
import java.util.*;

public class Main {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int positionX = Arrays.binarySearch(arr, x);

        if (positionX < 0)
            positionX = positionX * -1 - 2;

        if (arr.length == k) {
            for (int j : arr) {
                result.add(j);
            }

            return result;
        }

        if (x <= arr[0]) {
            for (int i = 0; i < k; i++)
                result.add(arr[i]);
            return result;
        }

        if (x >= arr[arr.length - 1]) {
            for (int i = 0; i < k; i++)
                result.add(arr[arr.length - (k - i)]);
            return result;
        }

        int left = positionX;
        int right = positionX + 1;

        while (result.size() < k) {
            if (left < 0) {
                result.add(arr[right++]);
            } else if (right > arr.length - 1) {
                result.add(arr[left--]);
            } else if (Math.abs(arr[left] - x) < Math.abs(arr[right] - x) ||
                    (Math.abs(arr[left] - x) == Math.abs(arr[right] - x) && arr[left] < arr[right])) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }

        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(m.findClosestElements(arr, 4, 5));

        int[] arr2 = {1, 1, 1, 10, 10, 10};
        System.out.println(m.findClosestElements(arr2, 1, 9));

        int[] arr3 = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        System.out.println(m.findClosestElements(arr3, 3, 5)); //4,7,7 -> 3,3,4
    }
}
