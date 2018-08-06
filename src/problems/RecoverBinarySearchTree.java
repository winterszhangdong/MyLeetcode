package problems;

import utils.TreeNode;

/**
 * problem 99: Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 * Input: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * Example 2:
 * Input: [3,1,4,null,null,2]
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    private TreeNode mistakeNode1;
    private TreeNode mistakeNode2;
    private TreeNode preNode;

    public void solution(TreeNode root) {
        preNode = new TreeNode(Integer.MIN_VALUE);
        mistakeNode1 = null;
        mistakeNode2 = null;

        traverse(root);

        mistakeNode1.val = mistakeNode1.val ^ mistakeNode2.val;
        mistakeNode2.val = mistakeNode2.val ^ mistakeNode1.val;
        mistakeNode1.val = mistakeNode2.val ^ mistakeNode1.val;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);

        if (root.val < preNode.val) {
            if (mistakeNode1 == null)
                mistakeNode1 = preNode;
            if (mistakeNode1 != null)
                mistakeNode2 = root;
        }

        preNode = root;

        traverse(root.right);
    }
}
