package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ProductofTwoRunLengthEncodedArrays {

    /**
     * Good idea actually, add multiplied value if previous is not the same. lets do it.
     *
     *
     * @time-complexity - O (n + m).
     * @space-complexity - O (1).
     */
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int p1 = 0, p2 = 0;
        List<List<Integer>> ans = new ArrayList<>();

        while (p1 < encoded1.length && p2 < encoded2.length) {
            int val1 = encoded1[p1][0], len1 = encoded1[p1][1];
            int val2 = encoded2[p2][0], len2 = encoded2[p2][1];

            int len = Math.min(len1, len2);
            int multiplied = val1 * val2;

            int size = ans.size();

            if (size - 1 >= 0 && ans.get(size - 1).get(0) == multiplied) {
                List<Integer> last = ans.get(size - 1);
                last.set(1, last.get(1) + len);
            }
            else{
                List<Integer> newEntry = new ArrayList<>();
                newEntry.add(multiplied);
                newEntry.add(len);
                ans.add(newEntry);
            }

            encoded1[p1][1] -= len;
            encoded2[p2][1] -= len;
            if (encoded1[p1][1] == 0) p1++;
            if (encoded2[p2][1] == 0) p2++;
        }

        return ans;
    }
}
