package asu.edu.arav.amazon.interview.dfs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaofIsland {
    // major maistake in my part is the fact that i am dummbo
    // when we do dfs we get what ?? level value only tht my friend is not the mas area
    // what is max area then, it is summation of u plus area of ur childs, each sub problem
    // has to worry about its own sub routine area thts idiot
    // no need to make the node available after back  tracking ass hole
    // once a max area dfs starts it will cover  every one my friend
    // pls do not jump the gun and land on your face evaluate a bit even though it takes time


    int[] xvar = {0, 1, 0, -1};
    int[] yvar = {1, 0, -1, 0};
    int maxIslandArea = 0;


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return maxIslandArea;
        }

        // do dfs starting from each vertice if its not 0
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                maxIslandArea = Math.max(dfsStyleSearch(i, j, grid), maxIslandArea);
            }
        }
        return maxIslandArea;
    }

    public int dfsStyleSearch(int i, int j, int[][] grid) {
        // if the indexes are out of bound then return
        // shall we do this or reduce recursion calls it self
        // we should reduce recursion I guess, ok


        // make the current not accessible for others while children are being explored
        grid[i][j] = 0;
        // cuurent area would be 1
        int area = 1;
        // now start exploring its candidate children
        for (int k = 0; k < xvar.length; k++) {
            int nI = i + xvar[k];
            int nJ = j + yvar[k];
            // if not valid option continue;
            if (nI < 0 || nI > grid.length - 1 || nJ < 0 || nJ > grid[0].length - 1 || grid[nI][nJ] == 0) {
                continue;
            }
            area += dfsStyleSearch(nI, nJ, grid); // curarea is area formed till its parent
        }
        // no need to mark it unused as once part of a connected component we need not come again
        return area;
    }
}
