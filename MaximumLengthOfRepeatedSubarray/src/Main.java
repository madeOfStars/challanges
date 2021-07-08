/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class Main {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] cross = new int[nums1.length + 1][nums2.length + 1];

        int max = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    cross[i][j] = cross[i - 1][j - 1] + 1;
                    max = Math.max(max, cross[i][j]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] num11 = {1, 2, 3, 2, 1};
        int[] num12 = {3, 2, 1, 4, 7};
        System.out.println(m.findLength(num11, num12));

        int[] num21 = {0, 0, 0, 0, 0};
        int[] num22 = {0, 0, 0, 0, 0};
        System.out.println(m.findLength(num21, num22));

        int[] num31 = {0, 0, 0, 0, 1};
        int[] num32 = {1, 0, 0, 0, 0};
        System.out.println(m.findLength(num31, num32));
    }
}
