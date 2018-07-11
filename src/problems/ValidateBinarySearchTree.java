package problems;

import utils.TreeNode;

import java.util.ArrayList;

/**
 * problem 98: Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public boolean solution(TreeNode root) {
        if (root == null)
            return true;

        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();

        if (root.left != null) {
            if (root.left.val >= root.val || !isValidBST(root.left, leftList))
                return false;
        }

        if (root.right != null) {
            if (root.right.val <= root.val || !isValidBST(root.right, rightList))
                return false;
        }

        for (int n : leftList) {
            if (n >= root.val)
                return false;
        }

        for (int n : rightList) {
            if (n <= root.val)
                return false;
        }

        return true;
    }

    private boolean isValidBST(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) {
            if (root.left.val >= root.val || !isValidBST(root.left, list))
                return false;
            list.add(root.left.val);
        }

        if (root.right != null) {
            if (root.right.val <= root.val || !isValidBST(root.right, list))
                return false;
            list.add(root.right.val);
        }

        return true;
    }
}
