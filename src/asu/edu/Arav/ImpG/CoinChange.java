package asu.edu.Arav.ImpG;

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
        for(int i = coins.length-1; i >= 0; i --){
            noOfCoins+=amount/coins[i];
            amount %= coins[i];
            if(amount == 0){
                return noOfCoins;
            }
        }
        return -1;
    }

    public static int coinChange(int idx, int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        if(idx < coins.length && amount > 0){
           int maxCount = amount/coins[idx];
           for(int i = 0; i <= maxCount; i ++){
                int otherRecur = coinChange(idx+1, coins, amount - i * coins[idx]);
                if(otherRecur != -1)
                    minCost = Math.min(minCost, otherRecur + i);
           }
           if(minCost == Integer.MAX_VALUE){
               return -1;
           }else{
               return minCost;
           }
        }
        return -1;
    }

    public static int coinChange1(int [] coins, int amount){
        return coinChange(0, coins, amount);
    }

    public static void main(String [] args){
        int [] input = {1,2};
        System.out.println(coinChange1(input, 11));
    }
}
