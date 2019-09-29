package asu.edu.arav.leetcode.competition;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveDuplicatesRecur {

    public static String result = new String();

    public static String removeDuplicates(String s, int k) {

        if (s == null || s.length() == 0 || s.length() < k) {
            return s;
        }
        result = s;

        int continousSize = 1;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continousSize++;
            } else {
                continousSize = 1;
            }
            if (continousSize == k) {
                l = i - k + 1;
                r = i;
                break;
            }
        }
        // rec call with params
        if (l != r) {
            recursion(l, r, k);
        }

        return result;
    }

    public static void recursion(int l, int r, int k) {
        String s1 = result.substring(0, l);
        String s2 = result.substring(r + 1);
        result = s1 + s2;
        int continousSize = 1;
        int lr = 0, rr = 0;
        for (int i = 0; i < result.length(); i++) {
            if (i > 0 && result.charAt(i) == result.charAt(i - 1)) {
                continousSize++;
            } else {
                continousSize = 1;
            }

            if (continousSize == k) {
                lr = i - k + 1;
                rr = i;
                break;
            }
        }
        if (lr != rr) {
            recursion(lr, rr, k);
        }
    }
}
