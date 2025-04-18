package asu.edu.marisol;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IPO {

    class Project implements Comparable<Project> {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        public int compareTo(Project project) {
            return this.capital - project.capital;
        }
    }

    /**
     * Greedy, take the highest profit possible project which are available, the availability will be defined by capital
     * array.
     *
     * @time-complexity - O (nlogn + klogn ~ nlogn).
     * @space-complexity - O (n)
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Project[] projects = new Project[profits.length];

        for (int i = 0; i < profits.length; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }

        Arrays.sort(projects);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int firstNonAvailableProjectPointer = 0;

        for (int i = 0; i < k; i++) {
            while (firstNonAvailableProjectPointer < profits.length && w >= projects[firstNonAvailableProjectPointer].capital) {
                maxHeap.offer(projects[firstNonAvailableProjectPointer++].profit);
            }
            if (maxHeap.isEmpty()) break;

            w += maxHeap.poll();
        }

        return w;
    }
}
