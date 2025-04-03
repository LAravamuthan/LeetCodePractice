package asu.edu.marisol;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Candy {

    /**
     * Math solution.
     *
     * @time-complexity - O(n^2) iteration inside one other (whenever one changes).
     * @space-complexity - O(n) - IMO its constant space lets see (if dont consider answer as extra space), but we are
     * using that a intermediatte step only so you better say you used extra space.
     */
    public int candy(int[] ratings) {
        boolean hasChanged = true;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i > 0 && ratings[i - 1] < ratings[i] && candies[i - 1] >= candies[i]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                } else if (i < ratings.length - 1 && ratings[i + 1] < ratings[i] && candies[i + 1] >= candies[i]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }
            }
        }

        return Arrays.stream(candies).sum();
    }

    /**
     * Math solution.
     *
     * @time-complexity - O(2n ~ n) multiple iteration but not inner loops.
     * @space-complexity - O(2n ~ n) - 2 array solution.
     */
    public int candy2(int[] ratings) {
        int[] l2rCandies = new int[ratings.length];
        int[] r2lCandies = new int[ratings.length];
        Arrays.fill(l2rCandies, 1);
        Arrays.fill(r2lCandies, 1);

        // left to right
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i - 1] < ratings[i] && l2rCandies[i - 1] >= l2rCandies[i])
                l2rCandies[i] = l2rCandies[i - 1] + 1;
        }

        int sum = 0;
        // right to left.
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i + 1] < ratings[i] && r2lCandies[i + 1] >= r2lCandies[i])
                r2lCandies[i] = r2lCandies[i + 1] + 1;

           sum+= Math.max(l2rCandies[i], r2lCandies[i]);
        }

        return sum;
    }


    /**
     * Math solution, the same approach as O(3n) solution but this one is with O(n) space, that is one array only.
     *
     * @time-complexity - O(2n).
     * @space-complexity - O(n) - 1 array solution.
     */
    public int candy3(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // left to right
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i - 1] < ratings[i] && candies[i - 1] >= candies[i])
                candies[i] = candies[i - 1] + 1;
        }

        int sum = 0;
        // right to left with same array
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i + 1] < ratings[i] && candies[i + 1] >= candies[i])
                candies[i] = candies[i + 1] + 1;
            sum += candies[i];
        }

        return sum;
    }


    /**
     * Math solution, using slope concept has only one pass of O(n) and constant space.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1).
     */
    public int candy4(int[] ratings) {

        int n = ratings.length;
        int i = 1;
        int candies = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                candies++;
                i++;
                continue;
            }

            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candies += peak;
                i++;
            }

            int valley = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                candies += valley;
                valley++;
                i++;
            }

            candies += Math.max(valley - peak, 0);
        }

        return candies;
    }

}
