package asu.edu.arav.DP.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class WordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictHS = new HashSet<String>(wordDict);
        boolean [] possibleTillIndex = new boolean[s.length()+1];
        possibleTillIndex[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(possibleTillIndex[j] && wordDictHS.contains(s.substring(j, i))){
                    possibleTillIndex[i] = true;
                    break;
                }
            }
        }
        return possibleTillIndex[s.length()];
    }
}
