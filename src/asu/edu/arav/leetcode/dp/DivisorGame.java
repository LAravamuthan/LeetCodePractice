package asu.edu.arav.leetcode.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class DivisorGame {

    public static boolean divisorGame(int N) {
        boolean[] result = new boolean[N+1];
        result[0] = false;
        result[1] = false;
        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= i/2; j ++){
                if(i % j == 0){
                    if(result[i-j] == false){
                        result[i] = true;
                        break;
                    }
                }
            }
        }
        return result[N];
    }

    public static boolean divisorGame1(int N) {
        return N % 2 ==0;
    }

    public static void main(String[] args){
        System.out.println(divisorGame(6));
    }
}
