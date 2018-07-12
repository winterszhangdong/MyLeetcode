package problems;

import utils.ListNode;

/**
 * problem 142: Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode solution(ListNode head) {
        if (head == null)
            return null;

        ListNode p1 = head;
        ListNode p2 = head;

        do {
            if (p2.next == null || p2.next.next == null)
                return null;
            p1 = p1.next;
            p2 = p2.next.next;
        } while (p2 != p1);

        int perimeter = 0;
        do {
            p1 = p1.next;
            perimeter++;
        } while (p1 != p2);

        int count = 0;
        p2 = head;
        while (count != perimeter) {
            p2 = p2.next;
            count++;
        }

        p1 = head;
        while (p2 != p1) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
