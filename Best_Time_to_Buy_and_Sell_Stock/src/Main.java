/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class Main {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;

        int buyPrice = prices[0];
        int sellPrice = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
                sellPrice = 0;
            }
            sellPrice = Math.max(sellPrice, prices[i]);

            maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[]{7, 6, 4, 3, 1};
        int[] prices3 = new int[]{2, 4, 1};

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }
}
