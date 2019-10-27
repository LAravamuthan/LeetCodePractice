package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        // split version1 and version2 by "."
        String [] individualIntsVersion1 = version1.split("\\.");
        String [] individualIntsVersion2 = version2.split("\\.");

        // iterate to the index of lasrgest string
        int length = individualIntsVersion1.length > individualIntsVersion2.length ?
                individualIntsVersion1.length : individualIntsVersion2.length;


        for(int i = 0; i < length; i++){
            // get version Integer at each index start from 0
            // this is best to do if we do not want to worry about leading zeros
            // also it runs O(m) where m - max of length version1 and version2
            int version1Int = i < individualIntsVersion1.length ? Integer.parseInt
                    (individualIntsVersion1[i]) : 0;
            int version2Int = i < individualIntsVersion2.length ? Integer.parseInt
                    (individualIntsVersion2[i]) : 0;

            if(version1Int > version2Int){
                return 1;
            }else if(version1Int < version2Int){
                return -1;
            }
        }
        // if the integers match coool
        return 0;
    }
}
