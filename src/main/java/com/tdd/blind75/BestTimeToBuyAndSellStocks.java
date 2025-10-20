package com.tdd.blind75;

public class BestTimeToBuyAndSellStocks {

    // https://www.designgurus.io/viewer/document/grokking-the-coding-interview/6516a2167ace28abb69376f7

    /**
     * Solution 1: Two pointers
     *  First element min price
     *  Last element max price
     *  Loop on the window (index=1, index=length-1) update min and max price
     *
     *
     *  Solution 2:
     *      Define low pirce as Integer.max
     *      Define max profit as 0
     *      loop update low price compare with current
     *      update max profit = Math.max(max profit , (price-low price))
     */

    public int bestTimeToBuyAndSellStocks(int[] nums) {
        int lowPrice = nums[0];
        int highPrice = nums[nums.length - 1];

        for (int i = 1; i < (nums.length - 1); i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] < lowPrice) {
                lowPrice = nums[i];
            }
            if (nums[i] > highPrice) {
                highPrice = nums[i];
            }
            System.out.println(i + " low: " + lowPrice + " high: " + highPrice);
        }

        return highPrice - lowPrice;
    }

    public int bestTimeToBuyAndSellStocksVersionII(int[] nums) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : nums) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    static void main(String[] args) {
        BestTimeToBuyAndSellStocks test = new BestTimeToBuyAndSellStocks();
        int profit = test.bestTimeToBuyAndSellStocksVersionII(new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(profit);
    }
}
