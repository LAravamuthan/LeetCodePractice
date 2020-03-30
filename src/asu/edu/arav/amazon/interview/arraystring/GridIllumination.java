package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/grid-illumination/
 */
public class GridIllumination {

    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0,0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> rowLampCount = new HashMap<>();
        Map<Integer, Integer> colLampCount = new HashMap<>();
        Map<Integer, Integer> antiDiaLampCount = new HashMap<>();
        Map<Integer, Integer> diaLampCount = new HashMap<>();
        Set<Integer> lampLoc = new HashSet<>();

        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];
            int sum = r + c;
            int diff = r - c;
            rowLampCount.put(r, rowLampCount.getOrDefault(r, 0) + 1);
            colLampCount.put(c, colLampCount.getOrDefault(c, 0) + 1);
            antiDiaLampCount.put(sum, antiDiaLampCount.getOrDefault(sum, 0) + 1);
            diaLampCount.put(diff, diaLampCount.getOrDefault(diff, 0) + 1);
            lampLoc.add(lamp[0] * N + lamp[1]);
        }

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];
            int sum = r + c;
            int diff = r - c;

            if (rowLampCount.getOrDefault(r, 0) > 0 || colLampCount.getOrDefault(c, 0) > 0
                    || antiDiaLampCount.getOrDefault(sum, 0) > 0
                    || diaLampCount.getOrDefault(diff, 0) > 0) {
                res[i] = 1;
            }
            for (int j = 0; j < dirs.length; j++) {
                int nr = r + dirs[j][0];
                int nc = c + dirs[j][1];
                int nsum = nr + nc;
                int ndiff = nr - nc;
                int loc = nr * N + nc;
                if (nr >=0 && nr < N && nc >=0 && nc < N && lampLoc.contains(loc)) {
                    rowLampCount.put(nr, rowLampCount.getOrDefault(nr, 0) - 1);
                    colLampCount.put(nc, colLampCount.getOrDefault(nc, 0) - 1);
                    antiDiaLampCount.put(nsum, antiDiaLampCount.getOrDefault(nsum,0) - 1);
                    diaLampCount.put(ndiff, diaLampCount.getOrDefault(ndiff, 0) - 1);
                    lampLoc.remove(loc);
                }
            }
        }
        return res;
    }



    public static void main(String [] args){

        GridIllumination gl = new GridIllumination();

        gl.gridIllumination(5, new int [][] {{0,0},{0,4}}, new int[][] {{0,4},{0,1},{1,4}});

    }
}
