package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        // for every integer we have check every previous integer
        // maximum product and multiple the previous element
        // choose the max of all previous elements

        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        if(n <= 3){
            return dp[n];
        }
        dp[2] = 2;dp[3]=3;
        // maximum till 2 is 1 for 3 , it can be made 2,1,0 for each we get three products
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j,dp[j]) * (i - j)); // here math.max used is of huge importance
                //as it is to take max of value itself its product is lesser than it self this can be avoided if start from i = 4
                // lets try nope whenever some uses 2 or 3  with max function we would wrong answer,
                // so further do chutiyaap
                // lets do it
            }
        }

        return dp[n];
    }
    // math solution see later
    public int integerBreak1(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;

        return product;
    }
}
