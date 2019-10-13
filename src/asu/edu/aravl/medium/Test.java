package asu.edu.aravl.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class Test {

    public static void main(String args[]){
        List<Integer> t = new ArrayList<>();
        t.add(6);
        t.add(12);
        t.add(3);
        t.add(9);
        t.add(3);
        t.add(5);
        t.add(1);
        System.out.println(test(t, 12));
    }

    public static int test(List<Integer> arr, long k){
        int ans = 0;
        if(arr == null || arr.size() < 2){
            return 0;
        }
        Map<Long, Boolean> hm = new HashMap<>();
        for(long n : arr){

            if(hm.containsKey(k-n) && (!hm.get(k-n))){
                hm.put(k-n, true);
                hm.put(n, true);
                ans++;
            }
            if(!hm.containsKey(n)){
                hm.put(n, false);
            }

        }
        return ans;
    }
}
