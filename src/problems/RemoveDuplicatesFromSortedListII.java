package problems;

import utils.ListNode;

/**
 * problem 82 : Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode solution(ListNode head) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode quick = dummy;
        while (slow.next != null) {
            quick = quick.next;
            while (quick.next != null && quick.val == quick.next.val)
                quick = quick.next;
            if (slow.next != quick)
                slow.next = quick.next;
            else
                slow = slow.next;
        }

        return dummy.next;
    }
}
