package problems;

import utils.ListNode;

/**
 * problem 19: Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode solution(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++)
            first = first.next;

        if (first == null) {
            head = head.next;
            return head;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return head;
    }
}
