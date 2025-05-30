package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NumberofProvinces {

    /**
     * Union Find approach. this is enough IMO for now.
     *
     * @time-complexity - O (N^2).
     * @space-complexity - O (N).
     */
    public int findCircleNum(int[][] isConnected) {
        Dsu dsu = new Dsu(isConnected);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1)
                    dsu.union(i, j);
            }
        }

        return dsu.getCount();
    }

    class Dsu {
        int[] parents;
        int[] ranks;
        int count;

        public Dsu(int[][] isConnected) {
            parents = new int[isConnected.length];
            ranks = new int[isConnected.length];
            count = isConnected.length;

            for (int i = 0; i < isConnected.length; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parents[x]) return x;

            // path compression.
            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX != parentY) {
                if (ranks[parentX] > ranks[parentY])
                    parents[parentY] = parentX;
                else if (ranks[parentX] < ranks[parentY])
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
}
