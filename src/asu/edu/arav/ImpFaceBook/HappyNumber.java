package asu.edu.arav.ImpFaceBook;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static int[] digitsArray = new int[11];

    public static boolean isHappy(int n) {
        Set<Integer> foundSums = new HashSet<Integer>();
        int sum = n;
        int indexOfDigitsArray = 0;
        while (!foundSums.contains(sum)) {
            foundSums.add(sum);
            indexOfDigitsArray = getDigitsArray(sum);
            sum = 0;
            for (int i = 0; i < indexOfDigitsArray; i++) {
                sum += digitsArray[i] * digitsArray[i];
            }
            if (sum == 1) {
                return true;
            }

        }
        return false;
    }

    public static int getDigitsArray(int n) {
        int index = 0;
        while (n != 0) {
            digitsArray[index] = n % 10;
            n /= 10;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
