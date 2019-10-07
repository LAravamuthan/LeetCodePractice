package asu.edu.arav.leetcode.competition;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class LongestArithmeticSubSequenceofGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> mapZ = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            if(mapZ.containsKey(arr[i])){
                mapZ.get(arr[i]).add(i);
            }else{
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                mapZ.put(arr[i], temp);
            }

        }
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == Integer.MIN_VALUE) {
                continue;
            }
            st.push(arr[i]);
            arr[i] = Integer.MIN_VALUE;
            while (mapZ.containsKey(st.peek() + difference) && hasGreaterIndex(mapZ.get(st.peek() + difference),i)) {
                st.push(st.peek() + difference);
                mapZ.remove(arr[i]);
                arr[i] = Integer.MIN_VALUE;
            }
            max = Math.max(max, st.size());
            st.clear();
        }
        return max;
    }


    public boolean hasGreaterIndex(List<Integer> l, int idx){

        for(int i : l){
            if(idx < i){
                return true;
            }
        }

        return false;
    }
}
