public class Main2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main2 m = new Main2();
        int[] v1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}; //49
        int[] v2 = new int[]{1, 3, 2, 5, 25, 24, 5}; //24

        System.out.println(m.maxArea(v1));
        System.out.println(m.maxArea(v2));
    }
}
