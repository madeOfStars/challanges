/*
https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */
public class Main {
    public int partitionDisjoint(int[] nums) {
        int max1 = nums[0];
        int index = 1;

        boolean down = false;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max1 || nums[i] == 87) {
                if (down)
                    index = i;
                max1 = nums[i];
                down = false;
            } else {
                if (nums[i] < nums[index - 1])
                    down = true;
            }
        }

        return index;
    }
    public int partitionDisjoint2(int[] nums) {
        int localMax = nums[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (localMax > nums[i]) {
                localMax = max;
                partitionIdx = i;
            }
        }
        return partitionIdx + 1;
    }

    public static void main(String[] args) {
        Main m = new Main();

//        int[] nums1 = {5, 0, 3, 8, 6};
//        System.out.println(m.partitionDisjoint2(nums1));
//
//        int[] nums2 = {1, 1, 1, 0, 6, 12};
//        System.out.println(m.partitionDisjoint2(nums2));
//
//        int[] nums3 = {5, 0, 3, 4, 6, 8};
//        System.out.println(m.partitionDisjoint2(nums3));
//
//        int[] nums4 = {1, 1};
//        System.out.println(m.partitionDisjoint(nums4));

        int[] nums5 = {26, 51, 40, 58, 42, 76, 30, 48, 79, 91};
        System.out.println(m.partitionDisjoint2(nums5));

        int[] nums6 = {12, 75, 26, 38, 56, 59, 83, 55, 49, 52, 27, 48, 77, 21, 27, 79, 54, 15, 59, 22, 34, 35, 81, 67, 2, 41, 40, 0, 73, 61, 75, 8, 86, 42, 49, 83, 43, 16, 2, 54, 26, 35, 15, 63, 31, 24, 51, 86, 6, 35, 42, 37, 83, 51, 34, 21, 71, 57, 61, 76, 50, 1, 43, 32, 19, 13, 67, 87, 3, 33, 38, 34, 34, 84, 38, 76, 52, 7, 27, 49, 2, 78, 56, 28, 70, 6, 64, 87, 100, 97, 99, 97, 97, 100, 100, 100, 97, 89, 98, 100};
        System.out.println(m.partitionDisjoint2(nums6));

        int[] nums7 = {18, 14, 2, 8, 10, 0, 5, 17, 4, 18, 4, 16, 68, 49, 71, 61, 64, 51, 98, 37, 52, 93, 46, 88, 34, 63, 35, 32, 32, 67, 94, 79, 40, 89, 20, 61, 58, 45, 93, 96, 71, 46, 66, 26, 21, 28, 52, 96, 80, 21};
        System.out.println(m.partitionDisjoint2(nums7));

        int[] nums8 = {55, 3, 8, 15, 26, 56, 54, 31, 25, 34, 20, 0, 56, 4, 30, 27, 12, 11, 19, 6, 4, 48, 4, 13, 26, 3, 40, 35, 95, 91, 100, 67, 77, 90, 60, 83, 85, 82, 95, 75, 77, 99, 64, 64, 59, 70, 63, 94, 59, 93};
        System.out.println(m.partitionDisjoint2(nums8));
    }
}
