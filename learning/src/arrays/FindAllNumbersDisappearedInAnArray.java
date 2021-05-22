/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
package arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int r = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[r - 1] = r;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                result.add(i + 1);
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i))
                result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray f = new FindAllNumbersDisappearedInAnArray();

        int[] nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = new int[]{1, 1};
        System.out.println(f.findDisappearedNumbers1(nums1));
        System.out.println(f.findDisappearedNumbers1(nums2));

    }
}
