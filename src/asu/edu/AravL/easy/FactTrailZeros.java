package asu.edu.AravL.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FactTrailZeros {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n > 0){
            n /=5;
            ans+=n;
        }
        return ans;
    }
}
