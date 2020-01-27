package asu.edu.arav.amazon.interview.arraystring;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project Naveego
 */

public class Mixing {

    /* Class which to be used compare the counts
     * of various characters */
    public static class StrCount {
        private int count;
        private String str;

        public StrCount(int count, String str) {
            this.count = count;
            this.str = str;
        }
    }

    public static String mix(String s1, String s2) {

        /* array to store the counts each chars in s1 and s2 */
        int[] str1CharCounts = new int[26];
        int[] str2CharCounts = new int[26];

        /* Priority queue to keep StrCount objects sorted based on
         * count and if count is same, then lexicographically*/
        PriorityQueue<StrCount> pqStrChunks = new PriorityQueue<StrCount>(
                (a, b) -> a.count == b.count ? a.str.compareTo(b.str)
                        : b.count - a.count);
        setCharCount(s1, str1CharCounts);
        setCharCount(s2, str2CharCounts);
        for (int i = 0; i < 26; i++) {
            if (str1CharCounts[i] > 1 || str2CharCounts[i] > 1) {
                char ch = (char) ('a' + i);
                StringBuilder strChunk = new StringBuilder();
                int count = str1CharCounts[i];
                if (str1CharCounts[i] > str2CharCounts[i]) {
                    strChunk.append("1:");
                    strChunk.append(repeatChar(ch, str1CharCounts[i]));
                } else if (str2CharCounts[i] > str1CharCounts[i]) {
                    strChunk.append("2:");
                    strChunk.append(repeatChar(ch, str2CharCounts[i]));
                    count = str2CharCounts[i];
                } else {
                    strChunk.append("=:");
                    strChunk.append(repeatChar(ch, str1CharCounts[i]));
                }
                pqStrChunks.add(new StrCount(count, strChunk.toString()));
            }
        }
        StringBuilder res = new StringBuilder();
        /* create result based on the order as in the priority queue */
        while (!pqStrChunks.isEmpty()) {
            res.append(pqStrChunks.poll().str);
            res.append("/");
        }
        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    /* method to create string with characters repeated*/
    public static String repeatChar(char ch, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    /* method to set character count */
    public static void setCharCount(String str, int[] strCount) {
        for (int i = 0; i < str.length(); i++) {
            char curCh = str.charAt(i);
            if (curCh - 'a' >= 0 && curCh - 'a' <= 25) {
                strCount[curCh - 'a']++;
            }
        }
    }
}
