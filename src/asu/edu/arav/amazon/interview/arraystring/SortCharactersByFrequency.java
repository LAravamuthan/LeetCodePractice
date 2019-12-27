package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {

    // T - 3n ---> O(n), S - 3n ---> O(n) where n - no. of characters in String "s"
    public String frequencySort(String s) {
        if (s == null && s.length() == 0) {
            return s;
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();

        for (char ch : s.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> charFrequencyMap.get(b) - charFrequencyMap.get(a));
        for (char key : charFrequencyMap.keySet()) {
            pq.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char key = pq.poll();
            for (int i = 0; i < charFrequencyMap.get(key); i++) {
                sb.append(key);
            }
        }

        return sb.toString();
    }

}
