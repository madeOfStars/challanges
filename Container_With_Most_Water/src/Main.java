/*
Given n non-negative integers a1, a2, ..., an ,
where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.
 */

public class Main {
    public static int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[right], height[left]));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}; //49
        int[] v2 = new int[]{1, 3, 2, 5, 25, 24, 5}; //24

        System.out.println(maxArea(v1));
        System.out.println(maxArea(v2));
    }
}
