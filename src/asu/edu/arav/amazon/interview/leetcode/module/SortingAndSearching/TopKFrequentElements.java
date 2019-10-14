package asu.edu.arav.amazon.interview.leetcode.module.SortingAndSearching;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {


    public List<Integer> topKFrequent(int[] nums, int k) {
        if(k > nums.length){
            return null;
        }
        Map<Integer, Integer> numCounts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int key : numCounts.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new int[]{key, numCounts.get(key)});
            }else{
                if(minHeap.peek()[1] < numCounts.get(key)){
                    minHeap.add(new int[]{key, numCounts.get(key)});
                    minHeap.remove();
                }
            }
        }
        List<Integer> ansList = new ArrayList<Integer>();
        for(int[] keys : minHeap){
            ansList.add(keys[0]);
        }
        return ansList;
    }
}
