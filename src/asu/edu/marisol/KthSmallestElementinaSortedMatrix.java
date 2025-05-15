package asu.edu.marisol;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class KthSmallestElementinaSortedMatrix {

    /**
     * MinHeap usage.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (1)
     */
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        // value, row and col
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < Math.min(n, k); i++)
            pq.offer(new int[] { matrix[i][0], i, 0 });

        int[] element = pq.peek();

        while (k-- > 0) {
            element = pq.poll();
            int row = element[1]; int col = element[2];
            if (col < m - 1)
                pq.offer(new int [] { matrix[row][++col], row, col});
        }

        return element[0];
    }

    /**
     * Using binary on value instead index good concept.
     * TODO: Binary search variation keep this in mind.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (1)
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = matrix[0][0];
        int end = matrix[m - 1][n - 1];

        while (start < end) {
            int mid = start + (end - start) / 2;

            int[] smallestBiggestPair = new int[] { start, end };

            int count = countSmallElements(mid, matrix, smallestBiggestPair);

            if (count == k) {
                return smallestBiggestPair[0];
            } else if (count < k) {
                start = smallestBiggestPair[1];
            } else {
                end = smallestBiggestPair[0];
            }
        }

        return start;
    }

    private int countSmallElements(int value, int[][] matrix, int[] smallestBiggestPair) {

        int row = matrix.length - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < matrix[0].length) {
            int element = matrix[row][col];

            if (element > value) {
                row--;
                smallestBiggestPair[1] = Math.min(smallestBiggestPair[1], element);
            } else {
                col++;
                count += row + 1;
                smallestBiggestPair[0] = Math.max(smallestBiggestPair[0], element);
            }
        }

        return count;
    }

}
