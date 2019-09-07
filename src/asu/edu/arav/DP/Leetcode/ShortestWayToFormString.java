package asu.edu.arav.DP.Leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int count = 0;
        int positionConvered = 0;

        char [] s = source.toCharArray();
        char [] t = target.toCharArray();

        while(positionConvered < t.length){
            int prePositionCovered = positionConvered;
            positionConvered = findSubSeqInTar(s, t, positionConvered);
            if(positionConvered == prePositionCovered){
                return -1;
            }
            count++;
        }
        return count;
    }

    public int findSubSeqInTar(char[] s, char[] t, int positionCovered){
        for(int i = 0; i < s.length && positionCovered < t.length; i++){
            if(s[i] == t[positionCovered]){
                positionCovered++;
            }
        }
        return positionCovered;
    }


}
