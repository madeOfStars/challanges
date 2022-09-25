/*
https://leetcode.com/problems/car-pooling/
 */

public class Main {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] people = new int[1001];

        for (int[] trip : trips) {
            people[trip[1]] += trip[0];
            people[trip[2]] -= trip[0];
        }

        int count = 0;

        for (int person : people) {
            count += person;
            if (count > capacity)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] trips1 = new int[][] {
                {2,1,5},
                {3,3,7}
        };

        System.out.println(m.carPooling(trips1, 5));
    }
}
