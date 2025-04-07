package asu.edu.marisol;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class HappyNumber {

    /**
     * Mathematics simulation.
     *
     * @time-complexity - O(logN).
     * @space-complexity - O(logN).
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            n = getNext(n);
            if (seen.contains(n)) return false;
            seen.add(n);
        }
        return true;
    }

    private int getNext(int m) {
        int total = 0;

        while (m > 0) {
            int r = m % 10;
             m /= 10;
            total += r * r;
        }

        return total;
    }
}
