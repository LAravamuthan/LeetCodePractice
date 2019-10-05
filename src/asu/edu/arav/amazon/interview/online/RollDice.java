package asu.edu.arav.amazon.interview.online;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/discuss/interview-question/331158
 */
public class RollDice {
    public static int returnMinimumStepsToConvert(int [] diceFaces){
        if(diceFaces == null || diceFaces.length < 2){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int [] counter = new int[6];
        for(int dice : diceFaces){
            counter[dice - 1]++;
        }
        for(int i = 0; i < 6; i++){
            res = Math.min(counter[5 - i] + diceFaces.length - counter[i], res);
        }

        return res;
    }

    public static int returnMinimumStepsToConvert2(int [] diceFaces){
        if(diceFaces == null || diceFaces.length < 2){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < 7; i++){
            int moves = 0;
            for(int dice : diceFaces){
                if(dice == i){
                    continue;
                }
                else if (i + dice == 7){
                    moves += 2;
                }
                else{
                    moves += 1;
                }
            }
            res = Math.min(res, moves);
        }
        return res;
    }

    public  static void main(String[] args){
        System.out.println(returnMinimumStepsToConvert2(new int [] {1, 6,  2, 3}));
    }


}
