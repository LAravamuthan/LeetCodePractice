package asu.edu.arav.amazon.interview.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MaximumUtilization {

    public int[][] getroutes(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        List<int[]> result = new ArrayList<int[]>();
        int maxResult = Integer.MIN_VALUE;
        if (forwardRouteList.length == 0 || returnRouteList.length == 0) {
            return new int[0][0];
        }

        // sort the forward Rout List by the values
        Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
        // sort the forward Rout List by the values
        Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));

        /*
         * Here comes the two pointer approach which is pretty much sensible,
         * start in one array with smallest value,
         * start in other pointer with largest value,
         * the cost is more than target decrease the pointer for larger list
         * else if the cost is less target but more the maxCost so far then store the results
         * or else in either case increase the pointer for smaller list
         * */
        int fRLI = 0;
        int rRLI = returnRouteList.length - 1;
        while (fRLI < forwardRouteList.length && rRLI >= 0) {
            int cost = forwardRouteList[fRLI][1] + forwardRouteList[rRLI][1];
            if (cost > maxTravelDist) {
                rRLI--;
            } else {
                if (cost == maxResult) {
                    result.add(new int[]{fRLI, rRLI});
                } else if (cost > maxResult) {
                    result.clear();
                    result.add(new int[]{fRLI, rRLI});
                    int tr = rRLI - 1;
                    while (tr >= 0 && returnRouteList[rRLI][1] == returnRouteList[tr][1]) {
                        result.add(new int[]{fRLI, tr});
                        tr--;
                    }
                }
                fRLI++;
            }
        }

        int[][] resultantArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultantArray[i] = result.get(i);
        }
        return resultantArray;
    }
}
