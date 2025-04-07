package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class GroupAnagrams {

    /**
     * First approach is use sorting approach.
     *
     * @time-complexity - O (N KlogK ) k size of strings
     * @space-complexity - O (NK).
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char [] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.put(key, strings);
        }

        return new ArrayList<>(map.values());
    }


    /**
     * Second approach is use other novel approach of key making.
     *
     * @time-complexity - O (NK) k size of strings
     * @space-complexity - O (NK).
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char [] keyArray = new char[26];
            for (char ch : str.toCharArray()) keyArray[ch - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < keyArray.length; i++) {
                sb.append(keyArray[i]);
                sb.append("#");
            }
            String key = sb.toString();
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.put(key, strings);
        }

        return new ArrayList<>(map.values());
    }
}
