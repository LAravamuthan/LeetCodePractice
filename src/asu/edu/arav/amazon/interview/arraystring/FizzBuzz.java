package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        String threeString = "Fizz";
        String fiveString = "Buzz";
        String threeFiveString = "FizzBuzz";
        List<String> ansList = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ansList.add(threeFiveString);
            } else if (i % 3 == 0) {
                ansList.add(threeString);
            } else if (i % 5 == 0) {
                ansList.add(fiveString);
            } else {
                ansList.add(Integer.toString(i));
            }
        }

        return ansList;
    }
}
