package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class New21Game {

    public double new21Game(int N, int K, int W) {
        double[] winningProbalibilities = new double[N+W+1];

        for(int i = K; i <= N; i++){
            winningProbalibilities[i] = 1.0;
        }

        double numerator = Math.min(N-K+1, W);

        for(int i = K-1; i >= 0; i --){
            winningProbalibilities[i] = numerator/W;
            numerator += winningProbalibilities[i] - winningProbalibilities[i+W];
        }

        return winningProbalibilities[0];
    }
}
