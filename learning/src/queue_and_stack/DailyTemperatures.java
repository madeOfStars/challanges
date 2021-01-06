/*
https://leetcode.com/problems/daily-temperatures/
 */
package queue_and_stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] out = new int[T.length];
        out[T.length - 1] = 0;

        Stack<Integer> peaks = new Stack<>();

        for (int i = 0; i < T.length - 1; i++) {
            if (T[i] >= T[i + 1]) {
                peaks.push(i);
            } else {
                out[i] = 1;

                if (!peaks.isEmpty()) {
                    int nextWarmerDay = T[i + 1];

                    int peak = T[peaks.peek()];
                    while (nextWarmerDay > peak) {
                        int index = peaks.pop();
                        out[index] = i + 1 - index;
                        if (peaks.isEmpty())
                            break;
                        peak = T[peaks.peek()];
                    }
                }
            }
        }

        return out;
    }

    public static void main(String[] args) {
        int[] T1 = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] T2 = new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        System.out.println(Arrays.toString(dailyTemperatures(T1)));
        System.out.println(Arrays.toString(dailyTemperatures(T2)));
    }
}
