package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class WordBreak {

    /**
     * DP version of solving the problem.
     *
     * @time-complexity - O(N^3) -> s length.
     * @space-complexity - O(M^2 * N) -> M -> word length, N no. of wordlist.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String word = s.substring(i - 1, j);
                if(dp[i - 1] && wordDictSet.contains(word)) dp[j] = true;
            }
        }

        return dp[s.length()];
    }

    /**
     * BFS version of solving the problem.
     *
     * @time-complexity - O(N^3) -> s length.
     * @space-complexity - O(M^2 * N) -> M -> word length, N no. of wordlist.
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] seen = new boolean[s.length() + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int sizeCovered = q.poll();
            if (sizeCovered == s.length()) return true;
            for (int end = sizeCovered + 1; end <= s.length(); end++) {
                if (seen[end]) continue;
                String node = s.substring(sizeCovered, end);
                if (words.contains(node)) {
                    seen[end] = true;
                    q.offer(end);
                }
            }
        }

        return false;
    }


    /**
     * DFS top down dp approach.
     *
     * @time-complexity - O(N^3) -> s length.
     * @space-complexity - O(M^2 * N) -> M -> word length, N no. of wordlist.
     */
    public boolean wordBreak3(String s, List<String> wordDict) {

        this.memo = new int[s.length() + 1];
        Arrays.fill(this.memo, -1);
        this.s = s;
        this.wordDict = wordDict;

        return dp(s.length());
    }

    private int[] memo;
    private String s;
    private List<String> wordDict;

    private boolean dp(int i) {
        if (i == 0) return true;

        if (this.memo[i] != -1) return this.memo[i] == 1;

        for (String word : this.wordDict) {
            if (i - word.length() < 0) continue;
            String sub = this.s.substring(i - word.length(), i);
            if (sub.equals(word) && dp(i - word.length())) {
                this.memo[i] = 1;
                return true;
            }
        }

        this.memo[i] = 0;
        return false;
    }

    /**
     * DP version of solving the problem, Practice chey bhai.
     *
     * @time-complexity - O(N^3) -> s length.
     * @space-complexity - O(M^2 * N) -> M -> word length, N no. of wordlist.
     */
    public boolean wordBreak4(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    /**
     * DP version of solving the problem, Practice chey bhai.
     * In here we iterate over the wordSet.
     *
     * @time-complexity - O(N^3) -> s length.
     * @space-complexity - O(M^2 * N) -> M -> word length, N no. of wordlist.
     */
    public boolean wordBreak5(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordSet) {
                if (i - word.length() < 0)
                    continue;
                if (dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
