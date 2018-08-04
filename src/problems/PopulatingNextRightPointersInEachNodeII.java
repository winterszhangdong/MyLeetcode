package problems;

import utils.TreeLinkNode;

/**
 * problem 117: Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * Example:
 * Given the following binary tree,
 *
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   7
 *
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void solution(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode currentChild = dummy;
            while (root != null) {
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }

                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = dummy.next;
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII test = new PopulatingNextRightPointersInEachNodeII();
//        int[] nums = new int[]{1,2,3,4,5,Integer.MAX_VALUE,7};
//        TreeLinkNode
        test.solution(null);
    }
}
