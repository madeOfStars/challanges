/*
https://leetcode.com/problems/longest-increasing-subsequence/
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    private int search(List<Integer> seq, int k) {
        int left = 0;
        int right = seq.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (seq.get(mid) == k) {
                return mid;
            } else if (seq.get(mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;

        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int currNum = nums[i];

            if (currNum > seq.get(seq.size() - 1)) {
                seq.add(currNum);
            } else {
                int index = search(seq, currNum);
                seq.set(index, currNum);
            }
        }

        return seq.size();
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(m.lengthOfLIS(nums1)); //4

        int[] nums2 = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(m.lengthOfLIS(nums2)); //4

        int[] nums3 = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(m.lengthOfLIS(nums3)); //4
    }
}
