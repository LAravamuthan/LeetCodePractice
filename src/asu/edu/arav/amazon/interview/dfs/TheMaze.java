package asu.edu.arav.amazon.interview.dfs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/the-maze/
 */
public class TheMaze {


    /**
     *
     * @algo DFS
     * @time-complexity - O(n*m)
     * @space-complexity - O(n*m)
     *
     */

    boolean[][] visited = null;
    int [][] maze = null;
    int [] destination = null;
    int [] rDir = {0, 1, 0, -1};
    int [] cDir = {1, 0, -1, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        this.maze = maze;
        this.destination = destination;
        return dfs(start[0], start[1]);
    }

    public boolean dfs(int r, int c){
        if(r == destination[0] && c == destination[1]) return true;
        maze[r][c] = 1;
        for(int i = 0; i < rDir.length; i++){
            int nr = r + rDir[i];
            int nc = c + cDir[i];
            if(nr >=0 && nr < maze.length && nc >= 0 && nc < maze[0].length && maze[nr][nc] == 0){
                if(dfs(nr, nc)) return true;
            }
        }
        return false;
    }
}
