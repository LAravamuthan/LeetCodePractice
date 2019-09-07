package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountingBits {
    public int[] countBits(int num) {
        int ans[] = new int[num + 1];


        for (int i = 0; i <= num; i++) {
            ans[i] = returnSigBit(i);
        }


        return ans;
    }

    public int[] countBits1(int num) {
        int ans[] = new int[num + 1];
        int b = 0;
        int twoP = 1;
        while (twoP <= num) {
            while (b < twoP && b + twoP <= num) {
                ans[b + twoP] = ans[b] + 1;
                b++;
            }
            b = 0;
            twoP = 2 * twoP;
        }
        return ans;
    }

    public int returnSigBit(int x) {
        int count = 0;
        while (x != 0) {
            x &= x - 1;
            count++;
        }
        return count;
    }


}
