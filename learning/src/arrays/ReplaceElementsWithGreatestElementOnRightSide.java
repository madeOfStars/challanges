/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
package arrays;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        if (arr.length == 1)
            return new int[]{max};

        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            max = Math.max(temp, max);
            temp = arr[i];
            arr[i] = max;
        }

        return arr;
    }

    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSide r = new ReplaceElementsWithGreatestElementOnRightSide();

        int[] arr = new int[]{17, 18, 5, 4, 6, 1};

        System.out.println(Arrays.toString(r.replaceElements(arr)));
    }
}
