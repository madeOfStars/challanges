/*
https://leetcode.com/problems/trapping-rain-water/
 */

public class Main {

    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;

        int[] leftToRight = new int[size];
        leftToRight[0] = height[0];

        for (int i = 1; i < size; i++) {
            leftToRight[i] = Math.max(leftToRight[i - 1], height[i]);
        }

        int[] rightToLeft = new int[size];
        rightToLeft[size - 1] = height[size - 1];

        for (int i = size - 2; i > 0; i--) {
            rightToLeft[i] = Math.max(rightToLeft[i + 1], height[i]);
        }

        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }

        return ans;
    }

    public int trap1(int[] height) {
        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            ans += Math.min(leftMax, rightMax) - height[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

//        System.out.println(m.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(m.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
