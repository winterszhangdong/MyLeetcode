package problems;

import utils.ListNode;

/**
 * prblem 86: Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {
    public ListNode solution(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.val < x) {
            head = head.next;
        }

        if (head.next == null)
            return dummy.next;

        ListNode right = head.next;
        ListNode node;
        while (right.next != null) {
            if (right.next.val < x) {
                node =right.next;
                right.next = right.next.next;
                node.next = head.next;
                head.next = node;
                head = head.next;
            } else {
                right = right.next;
            }
        }

        return dummy.next;
    }
}
