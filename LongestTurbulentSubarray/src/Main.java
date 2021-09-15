/*
https://leetcode.com/problems/longest-turbulent-subarray/
 */
public class Main {
    public int maxTurbulenceSize(int[] arr) {
        int result = 1;
        int left = 0;
        int right = 1;
        int prev = 2;

        while (right < arr.length) {
            int curr = Integer.compare(arr[right], arr[right - 1]);

            if (curr == 0) {
                prev = curr;
                left = right;
                right++;
                continue;
            }

            if (curr != prev) {
                result = Math.max(right - left + 1, result);
            } else {
                left = right - 1;
            }
            prev = curr;
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(m.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(m.maxTurbulenceSize(new int[]{100}));
    }
}
