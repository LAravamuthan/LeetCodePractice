package asu.edu.Arav.DP.Leetcode;

public class SuperEggProblem {


    /*
        This numberofFloors is an array to hold maximum possible floor we can work out with eggs being the index
        Wat we do here is from the awesome fact that
        numberofFloors[i]  = 1 +  numberofFloors[i](from previous steps) + numberofFloors[i-1](from previous steps)
        as the number of steps builds up, we monitor the value numberofFloors[K](where K - is maximum eggs available)
        for it cross or equal N(which max Floor avaiable)
         */
    public int superEggDrop(int K, int N) {



        int[] numberOfFloors = new int[K + 1];
        int maxSteps = 0;
        for (; numberOfFloors[K] < N; maxSteps++) {
            for (int i = K; i > 0; i--) {
                numberOfFloors[i] = 1 + numberOfFloors[i] + numberOfFloors[i - 1];
            }
        }
        return maxSteps;
    }
    public int superEggDrop2(int K, int N) {

        


        return 0;
    }
}
