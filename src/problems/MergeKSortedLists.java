package problems;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * problem 23: Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode solution(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode head;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        head = queue.poll();
        ListNode node =head;
        while (queue.size() !=0) {
            if (node.next != null)
                queue.add(node.next);
            node.next = queue.poll();
            node = node.next;
        }

        return head;
    }
}
