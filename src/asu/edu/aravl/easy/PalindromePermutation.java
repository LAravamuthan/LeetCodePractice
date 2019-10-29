package asu.edu.aravl.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/palindrome-permutation/
 */
public class PalindromePermutation {

    // way one - where HaahMap and two passes are done
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        int oddCounts = 0;
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (char ch : charCount.keySet()) {
            if (charCount.get(ch) % 2 == 1) {
                oddCounts++;
            }
            if (oddCounts > 1) {
                break;
            }
        }

        return oddCounts <= 1;
    }

    //Lets try one HashMap but one pass only;
    public boolean canPermutePalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int oddCounts = 0;
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            if (charCount.get(ch) % 2 == 0) {
                oddCounts--;
            }
            if (charCount.get(ch) % 2 == 1) {
                oddCounts++;
            }
        }
        return oddCounts <= 1;
    }

    // using array instead of hashMap
    public boolean canPermutePalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int oddCounts = 0;
        int [] countArray = new int[128];
        for (char ch : s.toCharArray()) {
            countArray[ch]++;
            if (countArray[ch] % 2 == 0) {
                oddCounts--;
            }
            if (countArray[ch] % 2 == 1) {
                oddCounts++;
            }
        }
        return oddCounts <= 1;
    }

    // Lets try using Sets and see
    public boolean canPermutePalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        Set<Character> characterSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if(characterSet.contains(ch)){
                characterSet.remove(ch);
            }else{
                characterSet.add(ch);
            }

        }
        return characterSet.size() <= 1;
    }



}
