package asu.edu.arav.amazon.interview.dfs;

import asu.edu.aravl.utility.ListNode;
import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListtoBinarySearchTree {


    /**
     * @algo - dfs in order traversal
     * @time-complexity - O(n)
     * @space-complexity - O(logn)
     */

    public ListNode head = null;

    public int sizeOfLL(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public TreeNode dfsStyleInOrder(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = dfsStyleInOrder(l, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = this.head.next;
        node.right = dfsStyleInOrder(mid + 1, r);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        return dfsStyleInOrder(0, sizeOfLL(head) - 1);
    }
}
