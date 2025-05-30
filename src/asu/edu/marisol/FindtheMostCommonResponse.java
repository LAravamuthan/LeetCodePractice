package asu.edu.marisol;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FindtheMostCommonResponse {

    /**
     * Simple Set and Map usage.
     *
     * @time-complexity - O (N) - all the words in responses.
     * @space-complexity - O (M) - unique words in responses.
     */
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> stringCount = new HashMap<>();
        int maxCount = -1;
        String result = null;

        for (List<String> response : responses) {
            Set<String> uniqueStrings = new HashSet<>(response);
            for (String word : uniqueStrings) {
                stringCount.put(word, stringCount.getOrDefault(word, 0) + 1);
                int newCount = stringCount.get(word);
                if (newCount > maxCount || (newCount == maxCount && word.compareTo(result) < 0)) {
                    maxCount = newCount;
                    result = word;
                }
            }
        }

        return result;
    }
}
