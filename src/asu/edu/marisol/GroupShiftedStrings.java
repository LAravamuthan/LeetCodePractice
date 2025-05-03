package asu.edu.marisol;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class GroupShiftedStrings {

    /**
     * Simple 26 modulus approach.
     *
     * @time-complexity - O (M * K).
     * @space-complexity - O ().
     */
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();

        for (String string : strings) {
            if (string.length() == 1) {
                map.computeIfAbsent("single", k -> new ArrayList<>()).add(string);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < string.length(); i++) {
                int a = string.charAt(i - 1);
                int b = string.charAt(i);
                char diff = (char) (((b - a + 26) % 26) + 'a');
                sb.append(diff);
            }
            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(string);
        }

        List<List<String>> answer = new ArrayList<>();
        for (List<String> list : map.values()) {
            answer.add(list);
        }

        return answer;
    }


    /**
     * Cleaner hashkey method approach, same as before should run faster lets see.
     *
     * @time-complexity - O (M * K).
     * @space-complexity - O ().
     */
    public List<List<String>> groupStrings2(String[] strings) {

        Map<String, List<String>> hashKeyMap = new HashMap<>();

        for (String string : strings) {
            String hashKey = getHashKey(string);
            hashKeyMap.computeIfAbsent(hashKey, k -> new ArrayList<>()).add(string);
        }

        List<List<String>> answer = new ArrayList<>();
        for (List<String> list : hashKeyMap.values()) {
            answer.add(list);
        }

        return answer;
    }

    private String getHashKey(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < charArray.length; i++) {
            sb.append((char) ((charArray[i] - charArray[i - 1] + 26) % 26 + 'a'));
        }
        return sb.toString();
    }




}
