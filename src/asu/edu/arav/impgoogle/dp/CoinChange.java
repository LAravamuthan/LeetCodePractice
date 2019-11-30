package asu.edu.arav.impgoogle.dp;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int noOfCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            noOfCoins += amount / coins[i];
            amount %= coins[i];
            if (amount == 0) {
                return noOfCoins;
            }
        }
        return -1;
    }

    public static int coinChange(int idx, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        if (idx < coins.length && amount > 0) {
            int maxCount = amount / coins[idx];
            for (int i = 0; i <= maxCount; i++) {
                int otherRecur = coinChange(idx + 1, coins, amount - i * coins[idx]);
                if (otherRecur != -1)
                    minCost = Math.min(minCost, otherRecur + i);
            }
            if (minCost == Integer.MAX_VALUE) {
                return -1;
            } else {
                return minCost;
            }
        }
        return -1;
    }

    public static int coinChange1(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] sums = new int[amount + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (sums[i - coins[j]] != Integer.MAX_VALUE) {
                        sums[i] = Math.min(sums[i], sums[i - coins[j]] + 1);
                    }
                }
            }
        }
        return sums[amount] == Integer.MAX_VALUE ? -1 : sums[amount];
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 5};
        System.out.println(coinChange2(input, 11));
    }
}
