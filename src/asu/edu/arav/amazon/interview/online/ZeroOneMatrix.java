package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TwoDPoint;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ZeroOneMatrix {

    public int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {

        int[][] updatedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    updatedMatrix[i][j] = 0;
                } else {
                    updatedMatrix[i][j] = searchNearestZero(i, j, matrix);
                }
            }
        }
        return updatedMatrix;
    }

    public int searchNearestZero(int r, int c, int[][] matrix) {
        Queue<TwoDPoint> contour = new ArrayDeque<TwoDPoint>();
        contour.offer(new TwoDPoint(r, c));
        int steps = 0;
        while (!contour.isEmpty()) {
            for (int elementsInCurrentLevel = contour.size(); elementsInCurrentLevel > 0; elementsInCurrentLevel--) {
                TwoDPoint p = contour.poll();
                if (matrix[p.r][p.c] == 0) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    if (isPossibleToGoInADirection(p.r + dir[0], p.c + dir[1], matrix)) {
                        contour.offer(new TwoDPoint(p.r + dir[0], p.c + dir[1]));
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    public boolean isPossibleToGoInADirection(int r, int c, int[][] matrix) {
        if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
            return true;
        }
        return false;
    }

}
