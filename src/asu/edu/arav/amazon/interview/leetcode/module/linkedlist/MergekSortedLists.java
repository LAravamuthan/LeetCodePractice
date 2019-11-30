package asu.edu.arav.amazon.interview.leetcode.module.linkedlist;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {

    // we are going to merge the k sorted arrays in divide and conquer manner
    // pls keep note of that
    public ListNode mergeKLists(ListNode[] lists) {
        // null and length zero case
        if (lists == null || lists.length == 0) {
            return null;
        }
        // if only one sorted list is present just return the head of it
        if (lists.length == 1) {
            return lists[0];
        }
        MergeSortedLinkedList msll = new MergeSortedLinkedList();


        int i = 0;
        //int last = lists.length - 1; no need for last variable

        // we merge first and last , second and second last and so on

        /*while(i < last){
            int j = last;
            while(i < j){
                lists[i] = msll.mergeTwoLists(lists[i], lists[j]);
                i++;
                j--;
                // once we see that there are no more pairs left then we just change
                // the last variable to j why? because j points to the last pair that
                // was merged in this iteration
                if(i >= j){
                    last = j;
                    i = 0; // this is important step or else we wont start one more iteration of
                    // merging
                }
            }

        }*/
        // the whole above thing can be written simply as below
        int j = lists.length - 1;

        while (i < j) {
            lists[i] = msll.mergeTwoLists(lists[i], lists[j]);
            i++;
            j--;
            // once we see that there are no more pairs left then we just change
            // the last variable to j why? because j points to the last pair that
            // was merged in this iteration
            if (i >= j) {
                i = 0; // this is important step or else we wont start one more iteration of
                // merging
            }
        }
        return lists[0];
    }


}
