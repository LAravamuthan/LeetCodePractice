package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class StrobogrammaticNumberII {


    /**
     *
     * @algo - Recursion
     * @time-complexity -
     * @space-complexity -
     */

    public List<String> findStrobogrammatic(int n) {
        List<String> res = helper(1, n);
        return res;
    }

    public List<String> helper(int l, int r){
        List<String> res = new ArrayList<>();
        if(l == r) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }else if(l +1 == r){
            res.add("11");
            res.add("88");
            res.add("69");
            res.add("96");
            return res;
        }

        List<String> list = helper(l+1, r-1);

        for(String str : list ){
            if(l != 1) res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        return res;
    }
}
