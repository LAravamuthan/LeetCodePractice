package asu.edu.arav.amazon.interview.dp_dfs_imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII {

    // the approach may be dfs, I dont know how to fit dynamic paradigm here lets see

    List<String> ans = new ArrayList<String>();
    Set<String> wordDict = new HashSet<String>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        for (String word : wordDict) {
            this.wordDict.add(word);
        }
        dfsStyleRecursion(0, 0, s, new StringBuilder(), -1);
        return ans;
    }

    public void dfsStyleRecursion(int i, int j, String s, StringBuilder possibleAns, int matchedIdx) {
        // i - starting index of substring in question
        // j - ending index of substring in question
        // possibleAns is current recursion ansSoFar
        // recurse to select increasing substring
        if (j < s.length() - 1) {
            dfsStyleRecursion(i, j + 1, s, possibleAns, matchedIdx);
        }
        // if current substring makes a word you are ready branch out
        String currentString = s.substring(i, j + 1);
        StringBuilder newAnsString = null;
        if (wordDict.contains(currentString)) {
            matchedIdx = j;
            newAnsString = new StringBuilder(possibleAns);
            if (possibleAns.length() != 0) newAnsString.append(" ");
            newAnsString.append(currentString);
            // if there are more characters to be seen
            if (j < s.length() - 1) {
                dfsStyleRecursion(j + 1, j + 1, s, newAnsString, matchedIdx);
            }
        }
        if (j == s.length() - 1 && matchedIdx == j) {
            ans.add(newAnsString.toString());
        }
    }

    // this one has the time complexity of O(n*n*n) = n - idx,  n - idx and n - list of words
    // even this does not work
    // even this didnot work my good
    // now I know How to merge DP and DFS solutions
    // lets see how is that possible
    public List<String> wordBreak2(String s, List<String> wordDict) {

        for (String word : wordDict) {
            this.wordDict.add(word);
        }
        // here dp array is of  array of possible answers
        ArrayList<String>[] dp = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();
        dp[0].add("");

        for (int i = 1; i < s.length(); i++) {
            // ans list till ith idx
            ArrayList<String> ithAnsList = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                // if the we have mulitple answer from j and j to i we  have a substring we
                // add it to the i list, i.e each element of jth index + the substring
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String ans : dp[j]) {
                        if (ans.equals("")) {
                            ithAnsList.add(ans + s.substring(j, i));
                        } else {
                            ithAnsList.add(ans + " " + s.substring(j, i));
                        }
                    }
                }
            }
            dp[i] = ithAnsList;
        }

        return dp[s.length()];
    }

    // the first solution was actually cool, only problem was was backtracking from possible node
    // second tries to find answer using O(n^3) approach using only DP
    // Wat if we could leverage O(n^2) DP solution to get reduced backtracking
    // lets see how we go about this

    public List<String> wordBreak3(String s, List<String> wordDict) {

        int maxLenghtOfWord = Integer.MIN_VALUE;
        for (String word : wordDict) {
            maxLenghtOfWord = word.length() > maxLenghtOfWord ? word.length() : maxLenghtOfWord;
            this.wordDict.add(word);
        }
        // here dp array is of  array of possible answers
        ArrayList<Integer>[] dp = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<Integer>();
        dp[0].add(1);


        for (int i = 1; i <= s.length(); i++) {
            // possible indexes we can come come from in the list from ith id
            for (int j = i - 1; j >= i - maxLenghtOfWord && j >= 0; j--) {
                // if the we have multiple answer from j  to i we  have a substring we
                // add it to the i dp indexs if j also has move ahead (awesome point)
                if (dp[j] !=null && dp[j].size() > 0 && this.wordDict.contains(s.substring(j, i))) {
                    if(dp[i] == null){
                        dp[i] = new ArrayList<Integer>();
                    }
                    dp[i].add(j);
                }
            }
        }
        if(dp[s.length()] == null){
            return new ArrayList<>();
        }
        prunnedFS(new StringBuilder(), s, dp, s.length());
        return ans;
    }

    // do dfs on only paths that only possible using matrix previously made using DP in the method above

    public void prunnedFS(StringBuilder path, String s, List<Integer>[] dp, int end){
        if(end == 0){
            // this means we have come to start, and it is valid answer
            ans.add(path.substring(1)); // for first word we dont need the space character
            return;
        }
        for(int i : dp[end]){
            // for every word you can make from current end ,
            // start a new path , they lead to new answers

            StringBuilder newPath = new StringBuilder();
            newPath.append(" ");
            newPath.append(s.substring(i, end));
            newPath.append(path);
            prunnedFS(newPath, s, dp, i);
        }

    }


    public static void main(String[] args) {
        WordBreakII wb2 = new WordBreakII();
        List<String> s = new ArrayList<>();
        s.add("cat");
        s.add("cats");
        s.add("and");
        s.add("sand");
        s.add("dog");
        System.out.println(wb2.wordBreak2("catsanddog", s));
    }
}
