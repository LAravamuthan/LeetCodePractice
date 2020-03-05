package asu.edu.arav.impfacebook.linkedlist;

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

        while (secondLinkedList != null) {
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
        /*ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        //head.next.next = new ListNode(2);
        //head.next.next.next = new ListNode(2);
        //head.next.next.next.next = new ListNode(3);
        //head.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));*/

        if (((1 >> (4 - 1)) &
                1) == 1)
            System.out.println("SET");
        else
            System.out.println("NOT SET");

        int[] nums1 = new int[5];
        int maxBitCount = 1;
        for (int num : nums1) {
            if(Integer.toBinaryString(num).length() > maxBitCount){
                maxBitCount = Integer.toBinaryString(num).length();
            }
        }
        int maxCount = 0;
        for(int i = 0; i < maxBitCount; i++){
            int count = 0;
            for(int num : nums1 ){
                if (((num >> (i)) & 1) == 1) count++;
            }
            if(count > maxCount){
                maxCount = count;
            }
        }
        System.out.println(maxCount);

    }


}
