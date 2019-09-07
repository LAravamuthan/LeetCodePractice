package asu.edu.arav.impfacebook;

import asu.edu.aravl.utility.ListNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }


        ListNode firstPointer = head;
        ListNode secondPointer = head.next;

        while (secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }

        ListNode secondLinkedList = reverseList2(firstPointer.next);

        ListNode node = head;

        while(secondLinkedList != null){
            if (node.val == secondLinkedList.val) {
                node = node.next;
                secondLinkedList = secondLinkedList.next;
            } else {
                return false;
            }
        }
        return true;
    }


    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String args[]) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        //head.next.next = new ListNode(2);
        //head.next.next.next = new ListNode(2);
        //head.next.next.next.next = new ListNode(3);
        //head.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
