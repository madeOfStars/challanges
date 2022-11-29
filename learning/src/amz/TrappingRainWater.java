/*
https://leetcode.com/problems/trapping-rain-water/
 */

package amz;


public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

        int maxArea = 0;

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                maxArea += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                maxArea += maxRight - height[right];
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        TrappingRainWater m = new TrappingRainWater();

        System.out.println(m.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
