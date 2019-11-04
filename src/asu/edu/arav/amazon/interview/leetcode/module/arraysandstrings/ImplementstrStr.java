package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/implement-strstr/
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }

        char[] charHayStack = haystack.toCharArray();
        char[] charNeedle = needle.toCharArray();

        int needleLenght = needle.length();
        int macthedIndex = -1;
        int hayStackIdx = 0;
        for(char ch : charHayStack){
            if(ch == charNeedle[macthedIndex + 1]){
                macthedIndex++;
            }
            else{
                macthedIndex = -1;
                if(ch == charNeedle[macthedIndex + 1]){
                    macthedIndex++;
                }
            }
            if(macthedIndex == needleLenght -1 ){
                return hayStackIdx - macthedIndex;
            }
            hayStackIdx++;
        }
        return -1;
    }


}
