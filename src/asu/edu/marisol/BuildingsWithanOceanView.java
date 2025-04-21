package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BuildingsWithanOceanView {

    /**
     * Extra space controversial, coming from right.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int[] findBuildings(int[] heights) {

        List<Integer> indexes = new ArrayList<>();

        int maxHeight = -1;
        int n = heights.length;

        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                indexes.add(i);
                maxHeight = heights[i];
            }
        }

        int[] answer = new int[indexes.size()];

        for (int i = 0; i < indexes.size(); i++) {
            answer[i] = indexes.get(indexes.size() - 1 - i);
        }

        return answer;
    }

    /**
     * Extra space controversial, coming from left.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public int[] findBuildings2(int[] heights) {

        List<Integer> indexes = new ArrayList<>();
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (indexes.size() > 0 && heights[indexes.get(indexes.size() - 1)] <= heights[i])
                indexes.remove(indexes.size() - 1);
            indexes.add(i);
        }

        int[] answer = new int[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            answer[i] = indexes.get(i);
        }

        return answer;
    }


    /**
     * Extra space logic with stack.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int[] findBuildings3(int[] heights) {

        Stack<Integer> indexes = new Stack<>();
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!indexes.isEmpty() && heights[indexes.peek()] <= heights[i])
                indexes.pop();
            indexes.push(i);
        }

        int[] answer = new int[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            answer[i] = indexes.get(i);
        }

        return answer;
    }

}
