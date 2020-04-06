package asu.edu.arav.amazon.interview.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {


    /**
     *
     * @algo  BFS
     * @time-complexity - O(n^1/2)
     * @space-complexity  - O(n)
     */
    public int numSquares(int n) {
        if(n < 2) return 1;
        List<Integer> squares = new ArrayList<Integer>();
        for(int i = 1; i * i <= n ; i++) {
            squares.add(i * i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);
        int count = 0;
        while(!queue.isEmpty()){
            count += 1;

            Set<Integer> nqueue = new HashSet<Integer>();
            for(int remainder : queue){
                for(int square : squares){
                    if(remainder - square == 0) return count;
                    else if(remainder - square > 0) nqueue.add(remainder - square);
                }
            }
            queue = nqueue;
        }
        return count;
    }
}
