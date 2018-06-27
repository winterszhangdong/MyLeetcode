package problems;

import utils.ListNode;

/**
 * problem 2: Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int carry = 0;
        int sum;

        while (tmp1.next != null && tmp2.next != null) {
            sum = tmp1.val + tmp2.val + carry;
            carry = sum / 10;
            sum %= 10;
            tmp1.val = sum;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        if (tmp1.next == null && tmp2.next == null) {
            if (carry != 0) {
                tmp1.next = new ListNode(carry, null);
            }
        } else if (tmp1.next != null) {
            if (carry != 0) {
                
            }
        }

        return l1;
    }
}
