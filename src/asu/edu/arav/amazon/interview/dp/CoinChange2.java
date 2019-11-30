package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/coin-change-2/
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {

        // this is bit like coin change problem
        // but here we iterate  on coins first and inside we iterate
        // the previous amounts till we reach the current amount
        // why ?? if we make combinations of lower denomination coin
        // with higher denomination, then higher denomination calculation will have redundant
        // combinations ..... Think Again
        if(amount == 0){
            return 1;
        }// this is a special case where zero amount can be make with a choice of nothing

        if(coins == null || coins.length == 0){
            return 0;
        }
        // combinations for a amount
        int dp[] = new int[amount + 1];
        dp[0] = 1;

        for(int coin : coins){
            for(int x = coin; x <= amount; x ++){
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}
