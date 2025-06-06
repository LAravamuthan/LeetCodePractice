package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SnakesandLadders {

    /**
     * The usual graph BFS for shortest distance.
     *
     * @time-complexity - O(log n).
     * @space-complexity - O(1).
     */
    // TODO: Revisit Djistra algorithm for this problem
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int loc = 1;
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);

        // location on board for the player to row and cell in
        Pair<Integer, Integer> [] locationOfCells = new Pair[n * n + 1];

        // This list for reversing the col idx for loading the cell location.
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cols.add(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int col : cols) {
                locationOfCells[loc++] = new Pair<>(i, col);
            }
            // Imp step for making sure we iterate in order as defined in question context i.e
            // last row is the beginning and thereafter zigzag traversal as on the snake and ladders board.
            Collections.reverse(cols);
        }

        Queue<Integer> locationQueue = new ArrayDeque<>();
        dist[1] = 0;
        locationQueue.add(1);

        while (!locationQueue.isEmpty()) {
            int currLocation = locationQueue.remove();
            for (int nextLocation = currLocation + 1; nextLocation <= Math.min(currLocation + 6, n * n); nextLocation++) {
                int rowNext = locationOfCells[nextLocation].getKey();
                int colNext = locationOfCells[nextLocation].getValue();
                int destination = board[rowNext][colNext] != -1 ? board[rowNext][colNext] : nextLocation;

                if (dist[destination] == -1) {
                    dist[destination] = dist[currLocation] + 1;
                    locationQueue.add(destination);
                }
            }
        }

        return dist[n * n];
    }
}
