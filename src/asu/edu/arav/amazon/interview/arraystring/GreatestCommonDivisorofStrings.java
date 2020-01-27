package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class GreatestCommonDivisorofStrings {

    /**
     * @algo euclid algothim
     * @time-complexity -
     * @space-complexity -
     */

    public String gcdOfStrings(String str1, String str2) {
        if (str2.equals("")) {
            return str1;
        }
        if (str1.replaceAll(str2, "").equals(str1) && str2.replaceAll(str1, "").equals(str2)) {
            return "";
        }
        return gcdOfStrings(str2, str1.replaceAll(str2, ""));
    }
}
