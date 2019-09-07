package asu.edu.arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Two2KeyBoard {
    public int minSteps(int n) {
        int ans = 0; int d =2;
        while(n > 1){
            while(n %d  == 0){
                ans+= d;
                n/=d;
            }
            d++;
        }
        return ans;
    }
}
