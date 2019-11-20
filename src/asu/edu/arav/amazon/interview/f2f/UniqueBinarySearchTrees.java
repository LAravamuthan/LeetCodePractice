package asu.edu.arav.amazon.interview.f2f;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    // O(n^2) -- this algorithm is DP type algorithm
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        // no. of unique trees with index being the sequential elements
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // recurence relation here is simple
        // T(n) = with i at root i from 1 to n to T(i-1) * T(n-i)
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
