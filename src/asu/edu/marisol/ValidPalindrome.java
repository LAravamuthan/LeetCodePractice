package asu.edu.marisol;
/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidPalindrome {

    /**
     * The point here is the fact while operating "i" i.e front index or "n" i.e back index,
     * never operate on them if first index reaches the last index
     * Useful when many elements are to be removed.
     *
     * @time-complexity - O (n)
     * @space-complexity - O (1)
     */
    public boolean isPalindrome(String s) {
        int i = 0, n = s.length() - 1;
        while (i < n) {
            while(i < n && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i < n && !Character.isLetterOrDigit(s.charAt(n)))
                n--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(n)))
                return false;
            i++;
            n--;
        }
        return true;
    }
}
