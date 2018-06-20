package problems;

import utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode solution(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;

        if (headA == null || headB == null) {
            return null;
        }

        while (tmpA != null) {
            lenA++;
            tmpA = tmpA.next;
        }

        while (tmpB != null) {
            lenB++;
            tmpB = tmpB.next;
        }

        if (lenA > lenB) {
            int i = lenA - lenB;
            while (i > 0) {
                headA = headA.next;
                i--;
            }
        } else {
            int i = lenB - lenA;
            while (i > 0) {
                headB = headB.next;
                i--;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
