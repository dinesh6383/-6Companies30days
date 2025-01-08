package Amazon;

import java.util.*;

public class Calculating_Maximum_Profit {
    // recursive approach.
    public static int maxProfitRecursive(int[] stocks, int k) {
        int n = stocks.length;
        int[][][] dp = new int[n][2][k + 1];
        for(int[][] temp1 : dp) {
            for(int[] temp2 : temp1) {
                Arrays.fill(temp2, -1);
            }
        }
        return getMaximumProfit(0, 1, stocks, k, dp);
    }

    public static int getMaximumProfit(int idx, int buy, int[] stocks, int capacity, int[][][] dp) {
        System.out.println(idx + " " + buy + " " + capacity);
        if(idx == stocks.length || capacity == 0) return 0;

        if(dp[idx][buy][capacity] != -1) return dp[idx][buy][capacity];

        if(buy == 1) {
            return dp[idx][buy][capacity] =  Math.max(-stocks[idx] + getMaximumProfit(idx + 1, 0, stocks,  capacity, dp), 
                   0 + getMaximumProfit(idx + 1, 1, stocks, capacity, dp));
        } else {
            return dp[idx][buy][capacity] = Math.max(stocks[idx] + getMaximumProfit(idx + 1, 1, stocks, capacity - 1, dp), 
                   0 + getMaximumProfit(idx + 1, 0, stocks, capacity, dp));
        }
    }

    // iterative approach
    public static int maxProfitIterative(int[] stocks, int k) {
        int n = stocks.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        for(int idx = n - 1; idx >= 0; idx--) {
            for(int cap = k; cap > 0; cap--) {
                for(int buy = 0; buy <= 1; buy++) {
                    if(buy == 1) {
                        dp[idx][buy][cap] =  Math.max(-stocks[idx] + dp[idx + 1][0][cap],
                        0 + dp[idx + 1][1][cap]);
                    } else {
                        dp[idx][buy][cap] = Math.max(stocks[idx] + dp[idx + 1][1][cap - 1],
                        0 + dp[idx + 1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        
        // Recursive.
        int resultRecursie = maxProfitRecursive(prices, k);
        System.out.println("Recursive: " + resultRecursie);

        // Iterative.
        int resultIterative = maxProfitIterative(prices, k);
        System.out.println("Iterative: " + resultIterative);
    }
}