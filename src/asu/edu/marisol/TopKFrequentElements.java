package asu.edu.marisol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class TopKFrequentElements {

    /**
     * Priority queue implementation.
     *
     * @time-complexity - O(NLogK).
     * @space-complexity - O(N + K).
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        // Value and frequency.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> count.get(a)));

        for (int key : count.keySet()) {
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }

        int [] ans = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i] = pq.poll();
            i++;
        }

        return ans;
    }


    /**
     * Quick select implementation, Very imp for the interview.
     *
     * TODO: Read and memorize the same.
     *
     * @time-complexity - O(N) --> avg. O(N^2) ---> master theorem a = 1 and b = 2 one half basically -- > O(N)
     * @space-complexity - O(N).
     */
    public int[] topKFrequent2(int[] nums, int k) {
        this.count = new HashMap<>();

        for (int num : nums) this.count.put(num, this.count.getOrDefault(num, 0) + 1);

        this.keys = new int[this.count.keySet().size()];
        int i = 0;
        for (int key : this.count.keySet()) {
            keys[i] = key;
            i++;
        }
        int n = this.keys.length;
        quickSelect(0, n - 1, n - k);

        return Arrays.copyOfRange(this.keys, n - k, n);
    }

    private Map<Integer, Integer> count;
    private int[] keys;

    private void quickSelect(int left, int right, int k_smallest) {

        if (left == right) return;

        Random rand_num = new Random();
        int pivotIdx = left + rand_num.nextInt(right - left);

        pivotIdx = partition(left, right, pivotIdx);

        if (pivotIdx == k_smallest) return;
        // More elements are present on the left side, then we need choose smaller frequency pivot, to make less
        // no. of elements on the left
        else if (k_smallest < pivotIdx) quickSelect(left, pivotIdx - 1, k_smallest);
        // just opposite of previous of else if, i.e less elements on the left then we need to choose higher frequency pivot,
        // to make more no. of elements on the left
        else quickSelect(pivotIdx + 1, right, k_smallest);

    }

    private int partition(int left, int right, int pivotIdx) {
        int pivot_frequency = this.count.get(this.keys[pivotIdx]);

        // remember that partition index should be always start from left.
        int partition_index = left;

        // put the pivot num at the end of the current boundary.
        swap(pivotIdx, right);

        for (int i = left; i <= right; i++) {
            if (this.count.get(this.keys[i]) < pivot_frequency) {
                swap(i, partition_index);
                partition_index++;
            }
        }

        // put the pivot indexed to its partition index
        swap(right, partition_index);

        return partition_index;
    }

    private void swap(int a, int b) {
        int tmp = this.keys[a];
        this.keys[a] = this.keys[b];
        this.keys[b] = tmp;
    }

}
