package asu.edu.marisol;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class HIndex {

    /**
     * Sort and go over the indexes from 0th idx (treating that as the nth hindex), the moment h index <= value at the index
     * that is the maximum possible h index. It is so because, the numbers of elements after that index will less than the
     * current h index.
     *
     * For exampple [0, 1, 3, 5, 6], in this value 5 and 6 may be bigger numbers but, h index at 5 is 2 (given only 5 and 6 are
     * possible candidates from there) h index at 6 is 1. h at value 3 is 3 since value 3 and the next three elements are contributing
     * to h definitation and hidex 3 is satified by the values 3 , 5 , 6.
     *
     *
     * @time-complexity - O(nlogn).
     * @space-complexity - O(1).
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) return citations.length - i;
        }
        return 0;
    }

    /**
     * This solution works without sorting, works on the counting sort principle. Points to note, any citation value more
     * than the n value can be limited to n given h number cannot be more than n.
     * Second point in the counting sort array at the end will h value n, if the total count till that point is above h index
     * we are calculating we have the h index.
     *
     * @time-complexity - O(nlogn + n) - work it out pls
     * @space-complexity - O(N) - max recursion level will N depth long only.
     */
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int [] counts = new int[n + 1];
        for (int citation : citations) {
            counts[Math.min(citation, n)]++;
        }

        int sumOfEle = 0;
        for (int hidx = n; hidx >= 0; hidx--) {
            sumOfEle += counts[hidx];
            if (sumOfEle >= hidx) return hidx;
        }
        return 0;
    }
}
