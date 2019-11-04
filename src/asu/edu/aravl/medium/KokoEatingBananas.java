package asu.edu.aravl.medium;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
    static int[] pilesStatic;
    static int time;

    public static int minEatingSpeed(int[] piles, int H) {
        int currentNumber = 1;
        int previousNumber = 1;
        pilesStatic = piles;
        time = H;
        while (!willItCompleteBananas(currentNumber)) {
            previousNumber = currentNumber;
            currentNumber *= 2;
        }
        int l = previousNumber;
        int r = currentNumber;
        while (l < r) {
            if (willItCompleteBananas((l + r) / 2)) {
                r = (l + r) / 2;
            } else {
                l = (l + r) / 2 + 1;
            }
        }
        return l;
    }

    public static boolean willItCompleteBananas(int eatingSpeed) {
        double hoursTaken = 0;
        for (int i = 0; i < pilesStatic.length; i++) {
            // one of the awesome ways to do this is as follows
            // wat we want is 5/4 to be 2  but 4/4 to be 1 and
            // 3/4 to be doing -1 on numerator and +1 to the whole division
            // does eactly the same
            hoursTaken += (pilesStatic[i] - 1) / eatingSpeed + 1;
            if (hoursTaken > time) {
                break;
            }
        }
        return hoursTaken <= time;
    }

    public static void main(String args[]) {
        minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
    }
}
