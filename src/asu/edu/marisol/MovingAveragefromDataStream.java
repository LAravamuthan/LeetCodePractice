package asu.edu.marisol;

import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MovingAveragefromDataStream {



    /**
     * Storing min and values in stack.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1).
     */
    /*public MovingAveragefromDataStream(int size) {
        this.weightSum = 0;
        this.size = size;
        this.queue = new ArrayList<>();
    }*/

    /**
     * Storing min and values in stack.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (n).
     */
    public double next(int val) {
        this.queue.add(val);
        int q_size = this.queue.size();

        int tail = Math.max(0, q_size - this.size) > 0 ? this.queue.get(q_size - this.size - 1) : 0;

        this.weightSum = this.weightSum + val - tail;

        return (this.weightSum * 1.0) / Math.min(this.size, q_size);
    }


    private int weightSum;
    private int size;
    private List<Integer> queue;
    private int[] circularQueue;
    private int count;
    private int head;


    /**
     * Storing min and values in stack.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1).
     */
    public MovingAveragefromDataStream(int size) {
        this.weightSum = 0;
        this.size = size;
        this.circularQueue = new int[size];
        this.count = 0;
        this.head = 0;
    }

    /**
     * Storing min and values in stack.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (size).
     */
    public double next2(int val) {
        if (this.count < this.size ) ++count;
        int tail = (this.head + 1) % this.size;

        this.weightSum = this.weightSum + val - circularQueue[tail];
        this.head = (this.head + 1) % this.size;
        this.circularQueue[this.head] = val;
        return (this.weightSum * 1.0) / Math.min(this.size, this.count);
    }
}
