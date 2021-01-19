/*
https://leetcode.com/problems/flood-fill/
 */
package queue_and_stack;

import java.util.Arrays;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        int oldValue = image[sr][sc];
        floodFill(image, sr, sc, newColor, oldValue);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int newColor, int oldValue) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length)
            return;

        if (image[sr][sc] != oldValue)
            return;

        image[sr][sc] = newColor;
        floodFill(image, sr, sc - 1, newColor, oldValue);
        floodFill(image, sr - 1, sc, newColor, oldValue);
        floodFill(image, sr, sc + 1, newColor, oldValue);
        floodFill(image, sr + 1, sc, newColor, oldValue);
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();

        int[][] image1 = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] image2 = new int[][]{
                {0, 0, 0},
                {0, 1, 1}
        };

        System.out.println(Arrays.deepToString(ff.floodFill(image1, 1, 1, 2)));
        System.out.println(Arrays.deepToString(ff.floodFill(image2, 1, 1, 1)));
    }
}
