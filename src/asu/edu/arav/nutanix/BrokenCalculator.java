package asu.edu.arav.nutanix;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/broken-calculator/
 */
public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y < X) {
            ans++;
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
        }
        return ans + X - Y;
    }
}
