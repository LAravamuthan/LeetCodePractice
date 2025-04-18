package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ReverseWordsinaString {

    /**
     * Algorithm is remove useless extra space, and reverse the whole string and reverse individual strings.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWords(sb);
        return sb.toString();
    }

    private StringBuilder trimSpaces(String str) {
        int n = str.length();
        int left = 0;
        int right = n - 1;

        while (left <= right && str.charAt(left) == ' ') left++;
        while (right >= left && str.charAt(right) == ' ') right--;

        StringBuilder newSb = new StringBuilder();
        while (left <= right) {
            char ch = str.charAt(left);

            if (ch != ' ') newSb.append(ch);
            else if (newSb.charAt(newSb.length() - 1) != ' ') newSb.append(ch);
            left++;
        }
        return newSb;
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    private void reverseEachWords(StringBuilder sb) {
        int n = sb.length();
        int start = 0;
        int end = 0;

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') end++;
            reverse(sb, start, end - 1);

            start = end + 1;
            end++;
        }
    }

}
