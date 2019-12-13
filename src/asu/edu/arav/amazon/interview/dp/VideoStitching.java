package asu.edu.arav.amazon.interview.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/video-stitching/
 */
public class VideoStitching {

    // lets try the greedy approach first
    // O(nlogn)
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        // once sort from the start index so start from the a starting index we choose
        // possible points which will help us go further more far
        // but the catch here is start that the interval start should should be
        // smaller than the current the start

        int start = 0;
        int end = 0;
        int minClips = 0;
        while (start < T) {
            minClips++;
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= start) {
                    end = Math.max(end, clips[i][1]);
                }
            }
            start = end;
        }
        return minClips;
    }

    // lets try the knapsack version (sort of ) dp problem
    // O(nT) is the running time
    public int videoStitching2(int[][] clips, int T) {
        // here at every interval processing we get solution of old clip to make the new
        // clip size i tending to T
        // initialy all the video size will have the make possible value
        // max possible value here is T + 1 (since T is possbile )
        int dp[] = new int[T + 1];
        Arrays.fill(dp, T + 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] <= i && clip[1] >= i) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T];
    }
}
