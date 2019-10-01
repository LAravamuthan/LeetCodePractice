package asu.edu.arav.amazon.interview.online;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/subarrays-with-k-different-integers/
 */
public class SubArraysWithKDifferentIntegers {

    // SLW method in naive manner O(n^2)
    public static int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0 || A.length < K) {
            return 0;
        }
        int n = A.length;
        int answer = 0;

        for (int slwl = K; slwl <= n; slwl++) {
            HashMap<Integer, Integer> integerCount = new HashMap<Integer, Integer>();
            for (int i = 0; i < slwl; i++) {
                int counter = integerCount.getOrDefault(A[i], 0);
                integerCount.put(A[i], ++counter);
            }
            if (integerCount.size() == K) {
                answer++;
            }
            for (int i = slwl; i < n; i++) {
                int counter = integerCount.get(A[i - slwl]);
                integerCount.put(A[i - slwl], --counter);
                if (counter == 0) {
                    integerCount.remove(A[i - slwl]);
                }
                counter = integerCount.getOrDefault(A[i], 0);
                integerCount.put(A[i], ++counter);
                if (integerCount.size() == K) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /*





     */

    public static int subarraysWithKDistinctOptimal(int[] A, int K) {
        if (A == null || A.length == 0 || A.length < K) {
            return 0;
        }
        int n = A.length;
        int prefix = 0;
        int ans = 0;
        Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        for (int i = 0, j = 0; i < n; i++) {
            int count = mapCount.getOrDefault(A[i], 0);
            mapCount.put(A[i], ++count);
            if (mapCount.size() > K) {
                mapCount.remove(A[j]);
                j++;
                prefix = 0;
            }
            while (mapCount.get(A[j]) > 1) {
                prefix++;
                int counter = mapCount.get(A[j]);
                mapCount.put(A[j], --counter);
                j++;
            }
            if (mapCount.size() == K) {
                ans += 1 + prefix;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinctOptimal(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
