package asu.edu.arav.amazon.interview.f2f;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MaximumNumberOfBallons {

    public static int maxNumberOfBalloons(String text) {

        if (text == null || text.length() < 7) {
            return 0;
        }

        Map<Character, Integer> storedElements = new HashMap<Character, Integer>();

        for (int i = 0; i < text.length(); i++) {
            int count = storedElements.getOrDefault(text.charAt(i), 0);
            storedElements.put(text.charAt(i), ++count);
        }

        int result = Integer.MAX_VALUE;
        String baseWord = "balon";
        for (int i = 0; i < baseWord.length(); i++) {
            int count = storedElements.getOrDefault(baseWord.charAt(i), 0);
            int probablecountOfBalloon = count;
            if (baseWord.charAt(i) == 'l' || baseWord.charAt(i) == 'o') {
                probablecountOfBalloon = count / 2;
            }
            result = Math.min(result, probablecountOfBalloon);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
