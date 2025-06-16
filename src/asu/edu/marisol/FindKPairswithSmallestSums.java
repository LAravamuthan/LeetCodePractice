package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FindKPairswithSmallestSums {

    /**
     * Priority queue and using the property of two sorted or non-decreasing array.
     *
     * @time-complexity - O (klogk).
     * @space-complexity - O (k).
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();

        pq.offer(new int[] {nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair<>(0, 0));

        while (k-- > 0 && !pq.isEmpty()) {
            int [] curMin = pq.poll();
            int firstIdx = curMin[1];
            int secondIdx = curMin[2];

            List<Integer> curCombination = new ArrayList<>();
            curCombination.add(nums1[firstIdx]);
            curCombination.add(nums2[secondIdx]);
            ans.add(curCombination);

            if (firstIdx + 1 < nums1.length && !visited.contains(new Pair<>(firstIdx + 1, secondIdx))) {
                pq.offer(new int[] { nums1[firstIdx + 1] + nums2[secondIdx], firstIdx + 1, secondIdx });
                visited.add(new Pair<>(firstIdx + 1, secondIdx));
            }

            if (secondIdx + 1 < nums2.length && !visited.contains(new Pair<>(firstIdx, secondIdx + 1))) {
                pq.offer(new int[] { nums1[firstIdx] + nums2[secondIdx + 1], firstIdx, secondIdx + 1 });
                visited.add(new Pair<>(firstIdx, secondIdx + 1));
            }

        }

        return ans;
    }


    /**
     * Priority queue and using the property of two sorted or non-decreasing array.
     *
     * @time-complexity - O (klogk).
     * @space-complexity - O (k).
     */
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> ans = new ArrayList<>();

        pq.offer(new int[] {nums1[0] + nums2[0], 0, 0});

        while (k-- > 0 && !pq.isEmpty()) {
            int [] curMin = pq.poll();
            int i = curMin[1], j = curMin[2];

            List<Integer> curCombination = new ArrayList<>();
            curCombination.add(nums1[i]);
            curCombination.add(nums2[j]);
            ans.add(curCombination);

            if (j + 1 < nums2.length) pq.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            if (j == 0 && i + 1 < nums1.length) pq.offer(new int[] { nums1[i + 1] + nums2[j], i + 1, j });

        }

        return ans;
    }
}
