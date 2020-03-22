package asu.edu.arav.amazon.interview.filereader;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/read-n-characters-given-read4/
 */
public class ReadNCharactersGivenRead4 {

    /**
     * @algo - file reader
     * @time-complexity - N/A
     * @space-complexity - O(1)
     */

    public int read4(char [] ch){
        return 0;
    }

    public int read(char[] buf, int n) {
        int total = 0;
        char [] tmp = new char[4];
        boolean eof = false;
        while(!eof && total < n){
            int count = read4(tmp);
            eof = count < 4;
            count = Math.min(count, n-total);
            for(int i = 0; i < count; i++){
                buf[total++] = tmp[i];
            }
        }
        return total;
    }
}
