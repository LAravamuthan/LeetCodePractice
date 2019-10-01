package asu.edu.arav.amazon.interview.online;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bsSet = new HashSet<String>();

        for(String bs : banned){
            bsSet.add(bs.toLowerCase());
        }
        Map<String, Integer> sToCount = new HashMap<String, Integer>();

        String[] paraStrings = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        //String[] paraStrings = paragraph.split(" ");
        for(String ps : paraStrings){
            if(!bsSet.contains(ps)){
                int count = sToCount.getOrDefault(ps, 0);
                sToCount.put(ps, ++count);
            }
        }
        int max = Integer.MIN_VALUE;
        String res = "";
        for(String key : sToCount.keySet()){
            if(max < sToCount.get(key)){
                max = sToCount.get(key);
                res = key;
            }
        }

        return res;
    }

    public static void main(String [] args){
        String [] in = new String[]{"a"};
        mostCommonWord("a, a, a, a, b,b,b,c, c", in);
    }
}
