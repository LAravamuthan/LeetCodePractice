package asu.edu.arav.leetcode.competition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class UniqueOccurances {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> cs = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            int count = map.getOrDefault(arr[i],0);
            map.put(arr[i], ++count);
        }

        for(Integer key : map.keySet()){
            cs.add(map.get(key));
        }

        return cs.size()==map.size()?true:false;
    }


}
