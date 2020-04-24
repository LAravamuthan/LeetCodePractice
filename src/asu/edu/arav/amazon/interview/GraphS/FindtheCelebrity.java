package asu.edu.arav.amazon.interview.GraphS;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-the-celebrity/
 */
public class FindtheCelebrity {


    public boolean knows(int a, int b) {
        return false;
    }

    int N = 0;

    public int findCelebrity(int n) {
        int possibleCeleb = 0;
        N = n;
        for (int i = 0; i < n; i++) {
            if (possibleCeleb != i) {
                if (knows(possibleCeleb, i)) possibleCeleb = i;
            }
        }
        return isCeleb(possibleCeleb) ? possibleCeleb : -1;
    }

    public boolean isCeleb(int i) {
        for (int j = 0; j < N; j++) {
            if (j != i) {
                if (knows(i, j) || !knows(j, i))
                    return false;
            }
        }
        return true;
    }
}
