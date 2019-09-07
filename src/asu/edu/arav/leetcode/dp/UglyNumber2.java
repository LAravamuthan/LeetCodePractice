package asu.edu.arav.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class UglyNumber2 {

    public int[] uglyNumbers = new int[1690];


    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int[] primeFators = new int[]{2, 3, 5};


        Set<Integer> uglySet = new HashSet<Integer>();
        for (int i = 1; i <= 6; i++) {
            uglySet.add(i);
        }

        int temp = 6;
        int numberToCheck = 7;
        while (uglySet.size() < n) {

            for (int i = 0; i < primeFators.length; i++) {
                if (numberToCheck % primeFators[i] == 0) {
                    if (uglySet.contains(numberToCheck / primeFators[i])) {
                        uglySet.add(numberToCheck);
                        temp = numberToCheck;
                        break;
                    }
                }
            }
            numberToCheck++;
        }

        return temp;

    }

    public UglyNumber2() {
        uglyNumbers[0] = 1;
        int whoseTwo = 0;
        int whoseThree = 0;
        int whoseFive = 0;
        for (int i = 1; i < 1690; i++) {
            uglyNumbers[i] = Math.min(Math.min(uglyNumbers[whoseTwo] * 2, uglyNumbers[whoseThree] * 3), uglyNumbers[whoseFive] * 5);
            if(uglyNumbers[i] == uglyNumbers[whoseTwo] * 2){
                whoseTwo++;
            }else if(uglyNumbers[i] == uglyNumbers[whoseThree] * 3){
                whoseThree++;
            }else if(uglyNumbers[i] == uglyNumbers[whoseFive] * 5){
                whoseFive++;
            }
        }
    }


    public int nthUglyNumber2(int n) {
        UglyNumber2 ugN2 = new UglyNumber2();
        return ugN2.uglyNumbers[n-1];
    }

}
