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
public class FreqStack {

    // when we push what do we do

    // we push value to a stack which stack do we have to push,


    // Map for Storing keys and there frequiences
    Map<Integer, Integer> keyFrequencies = new HashMap<>();

    // Map for frequecy and its corresponding Stack of values who share those
    // frequencies
    Map<Integer, Stack<Integer>> freqStackMap = new HashMap<>();

    int maxFrequecy = Integer.MIN_VALUE;

    public FreqStack() {
    }

    public void push(int x) {
        int currentFreq = keyFrequencies.getOrDefault(x, 0);
        // increase the frequency of the value to be pushed
        keyFrequencies.put(x, currentFreq + 1);
        // push it in stack made for its new frequency
        Stack<Integer> frequencyStack = freqStackMap.getOrDefault(currentFreq + 1, new Stack<Integer>());
        frequencyStack.push(x);
        freqStackMap.put(currentFreq + 1, frequencyStack);
        // if new frequency is greater than the maxFrequency then update the max frequency
        if(currentFreq + 1 > maxFrequecy){
            maxFrequecy = currentFreq + 1;
        }
    }

    public int pop() {
        // if no elemets have been put then retuen -1
        if(maxFrequecy == Integer.MIN_VALUE){
            return -1;
        }
        int value = freqStackMap.get(maxFrequecy).pop();
        // if the stack current max frequency is empty decrement the maxFrequency
        if(freqStackMap.get(maxFrequecy).isEmpty()){
            maxFrequecy--;
        }
        // also decrease the frequecy of the popped value
        int currentFreq = keyFrequencies.getOrDefault(value, 0);
        keyFrequencies.put(value, currentFreq - 1);
        return value;
    }

    public static void main(String[] args){
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());

    }

}
