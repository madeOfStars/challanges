/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class Main {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;

            if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid;
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] arr1 = {0, 1, 0};
        System.out.println(m.peakIndexInMountainArray(arr1));

        int[] arr2 = {0, 2, 1, 0};
        System.out.println(m.peakIndexInMountainArray(arr2));

        int[] arr3 = {0, 10, 5, 2};
        System.out.println(m.peakIndexInMountainArray(arr3));

        int[] arr4 = {3, 4, 5, 1};
        System.out.println(m.peakIndexInMountainArray(arr4));

        int[] arr5 = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(m.peakIndexInMountainArray(arr5));

        int[] arr6 = {3,5,3,2,0};
        System.out.println(m.peakIndexInMountainArray(arr6));
    }
}
