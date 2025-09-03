package com.arrayProblems;

public class BestTimeToBuyAndSellStocks {
    //TC -> O(N) SC -> O(1);
    public static int maximizeProfit(int [] arr){
        int mini = arr[0];
        int profit = 0;
        for(int i = 0; i < arr.length; i++){
            int cost = arr[i] - mini;
            profit =Math.max(profit, cost);
            mini = Math.min(arr[i], mini);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maximizeProfit(stockPrices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
