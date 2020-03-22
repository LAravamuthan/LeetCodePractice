package asu.edu.arav.amazon.interview.filereader;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class ReadNCharactersGivenRead4IICallmultipletimes {

    /**
     *
     * @algo - file reading
     * @time-complexity - N/A
     * @space-complexity - O(1)
     */

    public int read4(char [] ch){
        return 0;
    }

    int offset = 0;
    int count = 0;
    char [] tmp = new char[4];
    public int read(char[] buf, int n) {
        int total = 0;
        while(total < n){
            if(offset == 0)
                count = read4(tmp);
            if(count == 0) break;
            while (offset < count && total < n)
                buf[total++] = tmp[offset++];
            if(offset == count) offset = 0;
        }
        return total;
    }
}
