package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/strobogrammatic-number/
 */
public class StrobogrammaticNumber {

    /**
     *
     * @algo - array
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */
    public boolean isStrobogrammatic(String num) {
        Set<String> patterns = new HashSet<String>();
        patterns.add("00");
        patterns.add("11");
        patterns.add("88");
        patterns.add("69");
        patterns.add("96");
        for(int l = 0, r = num.length() - 1; l <= r; l++, r--){
            if(!patterns.contains(num.charAt(l) + "" + num.charAt(r))){
                return false;
            }
        }
        return false;
    }


}
