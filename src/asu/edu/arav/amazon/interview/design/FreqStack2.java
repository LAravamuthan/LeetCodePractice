package asu.edu.arav.amazon.interview.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/maximum-frequency-stack/
 */
public class FreqStack2 {


    Map<Integer, Integer> keyVsFequencies = new HashMap<Integer, Integer>();
    Map<Integer, Stack<Integer>> frequencyToStackMap = new HashMap<Integer, Stack<Integer>>();
    int maxFrequency = Integer.MIN_VALUE;

    public FreqStack2() {

    }

    public void push(int x) {
        int freuency = keyVsFequencies.getOrDefault(x, 0);
        keyVsFequencies.put(x, freuency + 1);

        Stack<Integer> frequencyValues = frequencyToStackMap.getOrDefault(freuency + 1, new Stack<Integer>());
        frequencyValues.push(x);
        frequencyToStackMap.put(freuency + 1, frequencyValues);
        if (maxFrequency < freuency + 1) {
            maxFrequency = freuency + 1;
        }
    }

    public int pop() {
        if (maxFrequency == Integer.MIN_VALUE) {
            return -1;
        }
        int value = frequencyToStackMap.get(maxFrequency).pop();
        if (frequencyToStackMap.getOrDefault(maxFrequency, new Stack<Integer>()).isEmpty()) {
            maxFrequency--;
        }
        keyVsFequencies.put(value, keyVsFequencies.get(value) - 1);
        return value;
    }
}
