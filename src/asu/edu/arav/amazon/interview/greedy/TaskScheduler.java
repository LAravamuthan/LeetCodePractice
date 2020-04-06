package asu.edu.arav.amazon.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int[] charFreq = new int[26];

        for (char task : tasks) {
            charFreq[task - 'A']++;
        }
        Arrays.sort(charFreq);
        int time = 0;
        while (charFreq[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (charFreq[25] == 0) {
                    break;
                }
                if (i < 26 && charFreq[25 - i] > 0) {
                    charFreq[25 - i]--;
                }
                i++;
                time++;
            }
            Arrays.sort(charFreq);
        }
        return time;
    }

    public int leastInterval2(char[] tasks, int n) {

        int[] charFreq = new int[26];

        for (char task : tasks) {
            charFreq[task - 'A']++;
        }
        PriorityQueue<Integer> pqReverse = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) {
                pqReverse.offer(charFreq[i]);
            }
        }
        int time = 0;
        while (!pqReverse.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int i = 0;
            while (i <= n) {
                if (!pqReverse.isEmpty() && pqReverse.peek() > 1) {
                    temp.add(pqReverse.poll() - 1);
                } else {
                    pqReverse.poll();
                }
                time++;
                if (pqReverse.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
            for (int ele : temp) {
                pqReverse.offer(ele);
            }
        }

        return time;
    }

    public int leastInterval3(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] charFrequecy = new int[0];
        for (char task : tasks) {
            charFrequecy[task - 'A']++;
        }
        Arrays.sort(charFrequecy);
        int maxCoolingFreq = charFrequecy[25] - 1;
        int idleTime = maxCoolingFreq * n;
        for (int i = 24; i >= 0 && charFrequecy[i] > 0 && idleTime > 0; i--) {
            idleTime -= Math.min(charFrequecy[i], maxCoolingFreq);
        }

        return idleTime > 0 ? idleTime + tasks.length : tasks.length;
    }
}
