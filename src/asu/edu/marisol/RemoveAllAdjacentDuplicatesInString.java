package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RemoveAllAdjacentDuplicatesInString {

    /**
     * Approach with stack, wherein last character matches curent char, if that happens delete the previous element.
     *
     * @time-complexity - O (N)
     * @space-complexity - O (N - D), no of duplicates.
     */
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int resultLength = 0;
        for (char ch : s.toCharArray()) {
            if (ch == sb.charAt(resultLength - 1))
                sb.deleteCharAt(resultLength-- - 1);
            else {
                sb.append(ch);
                resultLength++;
            }
        }

        return sb.toString();
    }

}
