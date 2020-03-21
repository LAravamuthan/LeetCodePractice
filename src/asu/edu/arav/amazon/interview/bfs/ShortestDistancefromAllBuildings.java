package asu.edu.arav.amazon.interview.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/shortest-distance-from-all-buildings/
 */
public class ShortestDistancefromAllBuildings {

    /**
     * @algo - BFS
     * @time-complexity - O(n^2m^2)
     * @space-complexity - O(n^2m^2)
     */
    int[] row = {0, 1, 0, -1};
    int[] col = {1, 0, -1, 0};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int[][] dist = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];
        int buildingCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    boolean[][] isVisited = new boolean[grid.length][grid[0].length];
                    Queue<int[]> que = new ArrayDeque<>();
                    que.offer(new int[]{i, j});
                    int distLevel = 1;
                    while (!que.isEmpty()) {
                        int q = que.size();
                        for (int k = 0; k < q; k++) {
                            int[] coordinates = que.poll();
                            int r = coordinates[0];
                            int c = coordinates[1];
                            for (int mov = 0; mov < row.length; mov++) {
                                int nr = r + row[mov];
                                int nc = c + col[mov];
                                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
                                        && grid[nr][nc] == 0 && !isVisited[nr][nc]) {
                                    que.offer(new int[]{nr, nc});
                                    isVisited[nr][nc] = true;
                                    dist[nr][nc] += distLevel;
                                    reach[nr][nc]++;
                                }
                            }
                        }
                        distLevel++;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < dist.length; i ++){
            for(int j =0; j < dist[0].length; j++){
                if(grid[i][j] == 0 && buildingCount == reach[i][j])
                    min = Math.min(min, dist[i][j]);
            }
        }

        return min;
    }

}
