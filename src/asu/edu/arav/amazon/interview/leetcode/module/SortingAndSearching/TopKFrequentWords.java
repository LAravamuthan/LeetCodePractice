package asu.edu.arav.amazon.interview.leetcode.module.SortingAndSearching;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {




    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || words.length == 0){
            return new ArrayList<String>();
        }
        if(k > words.length){
            return null;
        }
        Map<String, Integer>  stringCount = new HashMap<String, Integer>();
        for(String  s : words){
            stringCount.put(s, stringCount.getOrDefault(s, 0)+1);
        }
        PriorityQueue<String> minHeapString = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(stringCount.get(o1).compareTo(stringCount.get(o2)) == 0){
                    return o2.compareTo(o1);
                }
                return stringCount.get(o1).compareTo(stringCount.get(o2));
            }
        });

        for(String word : stringCount.keySet()){
            if(minHeapString.size() < k){
                minHeapString.add(word);
            }else{
                if(stringCount.get(minHeapString.peek()) <= stringCount.get(word)){
                    minHeapString.add(word);
                    minHeapString.remove();
                }
            }
        }
        List<String> ansList = new ArrayList<String>();
        while(!minHeapString.isEmpty()){
            ansList.add(minHeapString.poll());
        }
        Collections.reverse(ansList);
        return ansList;
    }
}
