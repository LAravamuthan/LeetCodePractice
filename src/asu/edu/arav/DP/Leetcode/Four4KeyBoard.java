package asu.edu.arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Four4KeyBoard {
    public static int maxA(int N) {
        if (N == 0) {
            return 0;
        }
        int[] maxAsAtIdx = new int[N];
        maxAsAtIdx[0] = 1;
        int clipBoardAs = 0;
        for (int i = 1; i < N; i++) {
            if (i < 3) {
                maxAsAtIdx[i] = i + 1;
            } else {
                if (maxAsAtIdx[i - 3] * 2 >= maxAsAtIdx[i - 1] + 1) {
                    if (maxAsAtIdx[i - 3] * 2 >= maxAsAtIdx[i - 1] + clipBoardAs) {
                        maxAsAtIdx[i] = maxAsAtIdx[i - 3] * 2;
                        clipBoardAs = maxAsAtIdx[i - 3];
                    } else {
                        maxAsAtIdx[i] = maxAsAtIdx[i - 1] + clipBoardAs;
                    }
                } else {
                    if (maxAsAtIdx[i - 1] + 1 > maxAsAtIdx[i - 1] + clipBoardAs) {
                        maxAsAtIdx[i] = maxAsAtIdx[i - 1] + 1;
                    } else {
                        maxAsAtIdx[i] = maxAsAtIdx[i - 1] + clipBoardAs;
                    }
                }
            }
        }

        return maxAsAtIdx[N - 1];
    }

    public static int maxA1(int N) {
        if (N == 0) {
            return 0;
        }
        int[] maxAsAtIdx = new int[N];
        maxAsAtIdx[0] = 1;
        for (int i = 1; i < N; i++) {
            maxAsAtIdx[i] = maxAsAtIdx[i - 1] + 1;
            for (int j = 0; j < i - 2; j++){
                maxAsAtIdx[i] = Math.max(maxAsAtIdx[i], maxAsAtIdx[j] * (i - j - 1));
            }
        }
        return maxAsAtIdx[N - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxA1(7));
    }
}
