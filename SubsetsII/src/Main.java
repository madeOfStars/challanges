/*
https://leetcode.com/problems/subsets-ii/
 */
import java.util.*;

public class Main {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 1)
            return List.of(List.of(), List.of(nums[0]));

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();

        int max = 1 << nums.length;

        for (int i = 0; i < max; i++) {
            List<Integer> subset = new ArrayList<>();

            int k = i;
            int index = 0;

            while (k > 0) {
                if ((k & 1) > 0) {
                    subset.add(nums[index]);
                }

                k >>= 1;
                index++;
            }

            ArrayList<Integer> temp = new ArrayList<>(subset);
            if (!set.contains(temp)) {
                result.add(temp);
                set.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] nums1 = {1, 2, 2};
        System.out.println(m.subsetsWithDup(nums1));

        int[] nums2 = {0};
        System.out.println(m.subsetsWithDup(nums2));

        int[] nums3 = {1, 2};
        System.out.println(m.subsetsWithDup(nums3));

        int[] nums4 = {1, 2, 3};
        System.out.println(m.subsetsWithDup(nums4));

        int[] nums5 = {4,4,4,1,4};
        System.out.println(m.subsetsWithDup(nums5));
    }
}
