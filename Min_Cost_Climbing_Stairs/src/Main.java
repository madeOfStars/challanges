/*
https://leetcode.com/problems/min-cost-climbing-stairs/
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Integer, Integer> stepToCost = new HashMap<>();

    public static int minCostClimbingStairs(int[] cost) {
        stepToCost.clear();
        return minCostClimbingStairs(cost, -1);
    }

    public static int minCostClimbingStairs(int[] cost, int step) {
        if (stepToCost.containsKey(step))
            return stepToCost.get(step);

        if (step == cost.length - 1) {
            return cost[step];
        } else if (step > cost.length - 1) {
            return 0;
        } else {
            int min;
            if (step == -1) {
                min = Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, step + 2));
            } else {
                min = Math.min(minCostClimbingStairs(cost, step + 1), minCostClimbingStairs(cost, step + 2)) + cost[step];
            }
            stepToCost.put(step, min);
            return min;
        }
    }

    public static void main(String[] args) {
        int[] cost1 = new int[]{10, 15, 20};
        int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost3 = new int[]{0, 0, 1, 1};


        System.out.println(minCostClimbingStairs(cost1));
        System.out.println(minCostClimbingStairs(cost2));
        System.out.println(minCostClimbingStairs(cost3));
    }
}
