package asu.edu.aravl.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MovingAverage {

    private int[] window;
    private double sum = 0;
    private int windowIndex = 0;
    private int denominatorForAverage = 0;

    public MovingAverage(int size) {
        this.window = new int[size];
    }
    public double next(int val) {
        if(denominatorForAverage < window.length){
            denominatorForAverage++;
        }
        sum -= window[windowIndex];
        sum += val;
        window[windowIndex] = val;
        windowIndex = (windowIndex + 1) % window.length;
        return sum/denominatorForAverage;
    }

}
