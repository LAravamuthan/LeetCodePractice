package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaRepListMap =
                new HashMap<String, List<String>>();

        for (String s : strs) {
            int [] counts = new int[26];
            char [] chArray = s.toCharArray();
            for(char ch : chArray){
                counts[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < counts.length; i++){
                sb.append(counts[i]);
            }

            List<String> l = anaRepListMap.getOrDefault(sb.toString(), new ArrayList<>());
            l.add(s);
            anaRepListMap.put(sb.toString(), l);
        }
        List<List<String>> ansList = new ArrayList<>();
        for(String key : anaRepListMap.keySet()){
            ansList.add(anaRepListMap.get(key));
        }
        return ansList;
    }
}
