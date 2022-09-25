/*
https://leetcode.com/problems/buildings-with-an-ocean-view/
 */

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public int[] findBuildings(int[] heights) {
        if (heights.length == 1)
            return new int[]{0};

        Stack<Integer> tmpList = new Stack<>();
        int max = -1;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                tmpList.push(i);
                max = heights[i];
            }
        }

        int[] ans = new int[tmpList.size()];
        int index = 0;
        while (!tmpList.isEmpty()) {
            ans[index++] = tmpList.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(Arrays.toString(m.findBuildings(new int[]{4, 2, 3, 1})));
        System.out.println(Arrays.toString(m.findBuildings(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(m.findBuildings(new int[]{1, 3, 2, 4})));
    }
}
