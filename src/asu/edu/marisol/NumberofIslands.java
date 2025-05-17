package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NumberofIslands {

    /**
     * DFS approach.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (NM).
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        this.grid = grid;
        int noIsLands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noIsLands++;
                    dfs(i, j);
                }
            }
        }

        return noIsLands;
    }

    private char[][] grid;

    private void dfs(int row, int col) {

        int nr = grid.length;
        int nc = grid[0].length;

        if (row >= nr || col >= nc || row < 0 || col < 0 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);

    }


    /**
     * BFS approach.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (NM).
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int noIsLands = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noIsLands++;
                    queue.offer(i * nc + j);
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int node = queue.remove();
                        int r = node / nc;
                        int c = node % nc;
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            queue.offer((r + 1) * nc + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            grid[r][c + 1] = '0';
                            queue.offer(r * nc + c + 1);
                        }
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            grid[r - 1][c] = '0';
                            queue.offer((r - 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            grid[r][c - 1] = '0';
                            queue.offer(r * nc + c - 1);
                        }
                    }
                }
            }
        }

        return noIsLands;
    }

    class DSU {
        int[] parents;
        int[] ranks;
        int count;

        public DSU(char[][] grid) {
            int nr = grid.length;
            int nc = grid[0].length;

            parents = new int[nr * nc];
            ranks = new int[nr * nc];
            count = 0;

            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    if (grid[i][j] == '1') {
                        parents[nc * i + j] = nc * i + j;
                        ranks[nc * i + j] = 1;
                        count++;
                    }
                }
            }
        }

        public int find(int x) {
            if (x == parents[x]) return x;

            // path compression.
            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (ranks[x] > ranks[y]) {
                    parents[rootY] = rootX;
                } else if (ranks[x] < ranks[y]) {
                    parents[rootX] = rootY;
                } else {
                    ranks[x] += 1;
                    parents[rootX] = rootY;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    /**
     * Union Find approach.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (N*M).
     */
    public int numIslands3(char[][] grid) {

        DSU dsu = new DSU(grid);

        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        dsu.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        dsu.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        dsu.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        dsu.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return dsu.getCount();
    }


    /**
     * DFS approach.
     *
     * @time-complexity - O (NM).
     * @space-complexity - O (NM).
     */
    public int numIslands4(char[][] grid) {
        int isLands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    isLands++;
                    dfs(i, j, grid);
                }
            }
        }

        return isLands;
    }

    private void dfs(int row, int col, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (row >= n || row < 0 || col >= m || col < 0 || grid[row][col] == '0') return;

        grid[row][col] = '0';

        dfs (row - 1, col, grid);
        dfs (row, col + 1, grid);
        dfs (row + 1, col, grid);
        dfs (row, col - 1, grid);

    }

    /**
     * BFS approach.
     *
     * @time-complexity - O (NM).
     * @space-complexity - O (NM).
     */
    public int numIslands5(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int nr = grid.length, nc = grid[0].length;
        int isLand = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    isLand++;
                    queue.offer(i * nc + j);
                    while (!queue.isEmpty()) {
                        int node = queue.poll();
                        int row = node / nc, col = node % nc;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '0';
                            queue.offer((row - 1) * nc + col);
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            queue.offer((row + 1) * nc + col);
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            queue.offer(row * nc + col + 1);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            queue.offer(row * nc + col - 1);
                        }
                    }
                }
            }
        }

        return isLand;
    }

    class Dsu {
        private int[] parents;
        private int[] ranks;
        private int count;

        public Dsu(char[][] grid) {
            int nr = grid.length, nc = grid[0].length;
            parents = new int[nr * nc];
            ranks = new int[nr * nc];
            count = 0;

            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    if (grid[i][j] == '1') {
                        parents[i * nc + j] = i * nc + j;
                        ranks[i * nc + j] = 1;
                        count++;
                    }
                }
            }
        }

        public int findParent(int x) {
            if (x == parents[x]) return x;

            // path compression.
            return parents[x] = findParent(parents[x]);
        }

        public void unionByRank(int x, int y) {
            int parentX = findParent(x);
            int parentY = findParent(y);

            if (parentX != parentY) {
                if (ranks[parentX] > ranks[parentY])
                    parents[parentY] = parentX;
                else if (ranks[parentY] > ranks[parentX])
                    parents[parentX] = parentY;
                else {
                    parents[parentY] = parentX;
                    ranks[parentX] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return this.count;
        }

    }

    /**
     * Union-Find approach.
     *
     * @time-complexity - O (NM).
     * @space-complexity - O (NM).
     */
    public int numIslands6(char[][] grid) {
        int nr = grid.length, nc = grid[0].length;
        Dsu dsu = new Dsu(grid);

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    if (r - 1 >= 0 && grid[r - 1][c] == '1')
                        dsu.unionByRank(r * nc + c, (r - 1) * nc + c);
                    if (c + 1 < nc && grid[r][c + 1] == '1')
                        dsu.unionByRank(r * nc + c, r * nc + c + 1);
                    if (r + 1 < nr && grid[r + 1][c] == '1')
                        dsu.unionByRank(r * nc + c, (r + 1) * nc + c);
                    if (c - 1 >= 0 && grid[r][c - 1] == '1')
                        dsu.unionByRank(r * nc + c, r * nc + c - 1);
                }
            }
        }

        return dsu.getCount();
    }


}
