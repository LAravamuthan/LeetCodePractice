package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0 || S == null || S.length() == 0){
            return 0;
        }
        Set<Character> jewels = new HashSet<Character>();
        for(char j : J.toCharArray()){
            jewels.add(j);
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(jewels.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
