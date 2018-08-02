package problems;

import utils.ListNode;

/**
 * problem 92: Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    public ListNode solution(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;
        ListNode start;
        ListNode mid;
        ListNode right;

        int count = 0;
        while (count < m - 1) {
            left = left.next;
            count++;
        }
        start = left;
        left = left.next;
        count++;

        mid = left.next;
        right = left.next.next;
        while (count < n) {
            mid.next = left;
            left = mid;
            mid = right;
            if (right != null)
                right = right.next;
            count++;
        }

        start.next.next = mid;
        start.next = left;

        return dummy.next;
    }
}
