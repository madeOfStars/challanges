/*
https://leetcode.com/problems/can-place-flowers/
 */

public class Main {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }

            if (count >= n)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(m.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(m.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        System.out.println(m.canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 0));
    }
}
