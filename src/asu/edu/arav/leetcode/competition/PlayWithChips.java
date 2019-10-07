package asu.edu.arav.leetcode.competition;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/play-with-chips/
 */
public class PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        if (chips == null || chips.length < 2) {
            return 0;
        }
        int n = chips.length;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if(chips[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
