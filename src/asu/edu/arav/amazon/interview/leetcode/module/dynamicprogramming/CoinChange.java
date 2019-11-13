package asu.edu.arav.amazon.interview.leetcode.module.dynamicprogramming;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (coins.length == 1) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return -1;
            }
        }
        // coins required to make certain amount
        int[] cCount = new int[amount + 1];
        cCount[0] = 0;//no coins needed for 0 amount

        //initialising first set of coin amounts
        for (int c : coins) {
            // to make that we dont use denomination bigger than the
            // amount
            if(c < amount + 1){
                cCount[c] = 1;
            }
        }
        // check each amt how to make it
        for (int i = 1; i <= amount; i++) {
            // if count has already not been found then only
            // find the best for it
            // this will only be in the case for initial first
            // cases of coins values it self
            if (cCount[i] == 0) {
                int minCoins = Integer.MAX_VALUE;
                // check each denomination option to make current amount
                for (int c : coins) {
                    if (i - c > 0 && cCount[i - c] > 0) {
                        minCoins = Math.min(minCoins, cCount[i - c]);
                    }
                }
                // choose the minimum one if possible or put -1
                cCount[i] = minCoins == Integer.MAX_VALUE ? -1 : minCoins + 1;
            }
        }
        return cCount[amount];
    }
}
