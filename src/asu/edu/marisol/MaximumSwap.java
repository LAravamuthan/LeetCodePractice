package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MaximumSwap {

    /**
     * Right side start and greedy approach, looks new lets try this out.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int maximumSwap(int num) {
        char[] numArray = Integer.toString(num).toCharArray();
        int n = numArray.length;

        int toBeSwappedCandidate = n - 1;
        int swapOne = -1, swapSec = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (numArray[i] > numArray[toBeSwappedCandidate]) {
                toBeSwappedCandidate = i;
            } else if (numArray[i] < numArray[toBeSwappedCandidate]) {
                swapOne = i;
                swapSec = toBeSwappedCandidate;
            }
        }

        if (swapOne != -1) swapChar(numArray, swapOne, swapSec);

        return swapOne == -1 ? num : Integer.parseInt(new String(numArray));
    }

    private void swapChar(char[] numArray, int i, int j) {
        char tmp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = tmp;
    }


    /**
     * more intuitive greedy approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (10 ~ 1).
     */
    public int maximumSwap2(int num) {
        char[] numArray = Integer.toString(num).toCharArray();
        int n = numArray.length;
        int[] lastSeen = new int[10];

        for (int i = 0; i < n; i++) lastSeen[numArray[i] - '0'] = i;

        for (int i = 0; i < n; i++) {
            for (int digit = 9; digit > numArray[i] - '0'; digit--) {
                if (i < lastSeen[digit]) {
                    char tmp = numArray[i];
                    numArray[i] = numArray[lastSeen[digit]];
                    numArray[lastSeen[digit]] = tmp;
                    return Integer.parseInt(new String(numArray));
                }
            }
        }

        return num;
    }

}
