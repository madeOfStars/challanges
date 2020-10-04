/*
Print the minimum nr of jump to reach the end of an array by avoiding 1s
 */

public class Main {
    static int jumpingOnClouds(int[] c) {
        int position = 0;
        int jump = 0;

        while (position < c.length) {
            if (position + 2 >= c.length - 1)
                return jump + 1;

            position += 2;

            if (c[position] == 1)
                position--;

            jump++;
        }

        return jump;
    }

    public static void main(String[] args) {
        int[] c1 = new int[]{0, 0, 1, 0, 0, 1, 0};
        int[] c2 = new int[]{0, 0, 0, 0, 1, 0};

        System.out.println(jumpingOnClouds(c1));
        System.out.println(jumpingOnClouds(c2));
    }
}
