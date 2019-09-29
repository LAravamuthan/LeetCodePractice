package asu.edu.arav.amazon.interview.online;

import java.util.HashMap;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class SubArraysWithKDifferentIntegers {






    // SLW method in naive manner O(n^2)
    public static int subarraysWithKDistinct(int[] A, int K) {
        if(A == null || A.length == 0 || A.length < K){
            return 0;
        }
        int n = A.length;
        int answer = 0;

        for(int slwl = K; slwl <= n; slwl++){
            HashMap<Integer, Integer> integerCount = new HashMap<Integer, Integer>();
            for(int i = 0; i < slwl; i++){
                int counter = integerCount.getOrDefault(A[i], 0);
                integerCount.put(A[i], ++counter);
            }
            if(integerCount.size() == K){
                answer++;
            }
            for(int i = slwl; i < n; i++){
                int counter = integerCount.get(A[i-slwl]);
                integerCount.put(A[i-slwl], --counter);
                if(counter == 0){
                    integerCount.remove(A[i-slwl]);
                }
                counter = integerCount.getOrDefault(A[i],0);
                integerCount.put(A[i], ++counter);
                if(integerCount.size() == K){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String [] args){
        subarraysWithKDistinct(new int[] {1,2,1,3,4}, 3);
    }
}
