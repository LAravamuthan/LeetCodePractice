package asu.edu.arav.impgoogle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int islands = 0;
        if (grid == null || grid.length == 0) {
            return islands;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    grid[i][j] = '0';
                    Queue<Integer> adja = new LinkedList<Integer>();
                    adja.add(j * nr + i);
                    while (!adja.isEmpty()) {
                        int combo = adja.remove();
                        int c = combo / nr;
                        int r = combo % nr;

                        if(c -1 >= 0 && grid[r][c-1] == '1'){
                            grid[r][c-1] = '0';
                            adja.add((c-1)*nr + r);
                        }
                        if(c + 1 < nc  && grid[r][c+1] == '1'){
                            grid[r][c+1] = '0';
                            adja.add((c+1)*nr + r);
                        }
                        if(r - 1 >= 0  && grid[r-1][c] == '1'){
                            grid[r-1][c] = '0';
                            adja.add((c)*nr + r-1);
                        }
                        if(r + 1 < nr && grid[r+1][c] == '1'){
                            grid[r+1][c] = '0';
                            adja.add((c)*nr + r+1);
                        }
                    }
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

}
