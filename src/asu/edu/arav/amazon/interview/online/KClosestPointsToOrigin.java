package asu.edu.arav.amazon.interview.online;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/k-closest-points-to-origin/solution/
 */
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pqPoints = new PriorityQueue<>((p1, p2) -> p2[2] - p1[2]);
        for (int i = 0; i < points.length; i++) {
            if(pqPoints.size() < K){
                pqPoints.offer(new int[]{points[i][0], points[i][1], distFromOrigin(points[i])});
            }else if (pqPoints.peek()[2] > distFromOrigin(points[i])) {
                pqPoints.offer(new int[]{points[i][0], points[i][1], distFromOrigin(points[i])});
            }
            if (pqPoints.size() > K) {
                pqPoints.poll();
            }
        }
        int[][] res = new int[pqPoints.size()][2];
        int count = 0;
        while (!pqPoints.isEmpty()){
            int [] point = pqPoints.poll();
            res[count][0] = point[0];
            res[count][1] = point[1];
            count++;
        }
        return res;
    }

    public static int distFromOrigin(int[] point) {
        return (point[0] - 0) * (point[0] - 0) + (point[1] - 0) * (point[1] - 0);
    }

    public static void main(String[] args){
        kClosest(new int [][] {{3,3},{5,-1},{-2,4}}, 2);
    }
}
