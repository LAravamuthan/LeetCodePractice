package asu.edu.marisol;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IsomorphicStrings {

    /**
     * Mapping approach between S and T.
     *
     * @time-complexity - O (N), length of Strings.
     * @space-complexity - O (1)
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int [] charterMapStoT = new int[256];
        int [] charterMapTtoS = new int[256];
        Arrays.fill(charterMapStoT, -1);
        Arrays.fill(charterMapTtoS, -1);

        for (int i = 0; i < s.length(); i ++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (charterMapStoT[ch1] == -1 && charterMapTtoS[ch2] == -1) {
                charterMapStoT[ch1] = ch2;
                charterMapTtoS[ch2] = ch1;
            } else if (!(charterMapStoT[ch1] == ch2 && charterMapTtoS[ch2] == ch1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Transformation of S and T.
     *
     * @time-complexity - O (N), length of Strings.
     * @space-complexity - O (N)
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;

        return transform(s).equals(transform(t));
    }

    private String transform(String s) {
        Map<Character, Integer> charIndex = new HashMap();
        StringBuilder sbTransformed = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charIndex.putIfAbsent(ch, i);
            sbTransformed.append(charIndex.get(ch));
            sbTransformed.append("#");
        }

        return sbTransformed.toString();
    }

    /**
     * Mapping approach between S and T.
     *
     * @time-complexity - O (N), length of Strings.
     * @space-complexity - O (1)
     */
    public boolean isIsomorphic3(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i), tCh = t.charAt(i);

            if (!sMap.containsKey(sCh) && !tMap.containsKey(tCh)) {
                sMap.put(sCh, tCh);
                tMap.put(tCh, sCh);
            } else if ((!sMap.containsKey(sCh) || sMap.get(sCh) != tCh)
                    || (!tMap.containsKey(tCh) || tMap.get(tCh) != sCh)) return false;
        }

        return true;
    }


    /**
     * Transformation of S and T, Practice again.
     *
     * @time-complexity - O (N), length of Strings.
     * @space-complexity - O (N)
     */
    public boolean isIsomorphic4(String s, String t) {
        return transform2(s).equals(transform2(t));
    }

    private String transform2(String s) {
        Map<Character, Integer> characterFirstOccurence = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!characterFirstOccurence.containsKey(ch))
                characterFirstOccurence.put(ch, i);
            sb.append(characterFirstOccurence.get(ch)).append('#');
        }

        return sb.toString();
    }
}
