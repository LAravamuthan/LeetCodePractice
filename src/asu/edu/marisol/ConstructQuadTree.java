package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    private boolean sameValue(int[][] grid, int x1, int y1, int length) {
        for (int i = x1; i < x1 + length; i++) {
            for (int j = y1; j < y1 + length; j++) {
                if (grid[x1][y1] != grid[i][j])
                    return false;
            }
        }
        return true;
    }

    private Node solve(int[][] grid, int x1, int y1, int length) {
        if (sameValue(grid, x1, y1, length)) {
            return new Node(grid[x1][y1] == 1, true);
        } else {
            Node root = new Node(false, false);

            root.topLeft = solve(grid, x1, y1, length/2);
            root.topRight = solve(grid, x1, y1 + length/2, length/2);
            root.bottomLeft = solve(grid, x1 + length/2, y1, length/2);
            root.bottomRight = solve(grid, x1 + length/2, y1 + length/2, length/2);

            return root;
        }
    }

    private Node solve2(int[][] grid, int x1, int y1, int length) {
        if (length == 1) {
            return new Node(grid[x1][y1] == 1, true);
        }

        Node topLeft = solve2(grid, x1, y1, length / 2);
        Node topRight = solve2(grid, x1, y1 + length / 2, length / 2);
        Node bottomLeft = solve2(grid, x1 + length / 2, y1, length / 2);
        Node bottomRight = solve2(grid, x1 + length / 2, y1 + length / 2, length / 2);

        boolean allLeafs = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
        boolean allSameValue = topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;

        if (allLeafs && allSameValue) return new Node(topLeft.val, true);

        return new Node(false, false, topLeft, topLeft, bottomLeft, bottomRight);
    }


}
