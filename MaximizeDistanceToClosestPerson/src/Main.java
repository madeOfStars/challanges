/*
https://leetcode.com/problems/maximize-distance-to-closest-person/
 */

public class Main {
    public int maxDistToClosest(int[] seats) {
        int max = -1;
        int last = 0;
        boolean first = true;

        int size = seats.length - 1;
        for (int i = 0; i < seats.length; i++) {
            int seat = seats[i];
            if (seat == 1) {
                if (last == 0 && first) {
                    max = i - last;
                } else {
                    max = Math.max(max, (i - last) / 2);
                }
                last = i;
                first = false;
            }
        }

        if (seats[size] == 0)
            return Math.max(seats.length - 1 - last, max);

        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] seats1 = new int[]{1, 0, 0, 0, 1, 0, 1};
        System.out.println(m.maxDistToClosest(seats1) + " 2"); // 2

        int[] seats2 = new int[]{1, 0, 0, 0};
        System.out.println(m.maxDistToClosest(seats2) + " 3"); // 3

        int[] seats3 = new int[]{0, 1};
        System.out.println(m.maxDistToClosest(seats3) + " 1"); // 1

        int[] seats4 = new int[]{1, 0};
        System.out.println(m.maxDistToClosest(seats4) + " 1"); // 1

        int[] seats5 = new int[]{1, 0, 0, 1};
        System.out.println(m.maxDistToClosest(seats5) + " 1"); // 1

        int[] seats6 = new int[]{0, 0, 1};
        System.out.println(m.maxDistToClosest(seats6) + " 2"); // 2

        int[] seats7 = new int[]{0, 0, 1, 0, 1, 1};
        System.out.println(m.maxDistToClosest(seats7) + " 2"); // 2
    }
}
