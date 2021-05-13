/*
https://leetcode.com/problems/valid-mountain-array/
 */
package arrays;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int i = 1;

        while (i < arr.length && arr[i] > arr[i - 1])
            i++;

        if (i == 1 || i == arr.length)
            return false;

        while (i < arr.length) {
            if (arr[i] >= arr[i - 1])
                return false;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidMountainArray vma = new ValidMountainArray();

        int[] arr1 = new int[]{2, 1};
        int[] arr2 = new int[]{3, 5, 5};
        int[] arr3 = new int[]{0, 3, 2, 1};
        int[] arr4 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(vma.validMountainArray(arr1));
        System.out.println(vma.validMountainArray(arr2));
        System.out.println(vma.validMountainArray(arr3));
        System.out.println(vma.validMountainArray(arr4));
    }
}
