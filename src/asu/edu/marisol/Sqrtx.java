package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Sqrtx {

    /**
     * Binary Search question lets do it.
     *
     * @time-complexity - O (amount * coins).
     * @space-complexity - O (amount).
     */
    public int mySqrt(int x) {

        if (x < 2) return x;
        int left = 2, right = x / 2;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            int squared = pivot * pivot;
            if (squared == x) return pivot;
            if (squared > x) right = pivot - 1;
            else left = pivot + 1;
        }

        return right;
    }

}
