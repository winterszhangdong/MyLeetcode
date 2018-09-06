package problems;

import utils.TreeNode;

import java.util.LinkedList;

/**
 * problem 111: Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down
 * to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree {
    public int solution(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        // the count of nodes of current level
        int cur = 1;
        // the count of nodes of next level
        int next = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null)
                return depth;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            cur--;
            if (cur == 0) {
                cur = next;
                next = 0;
                depth++;
            }
        }

        return depth;
    }

    public int solution2(TreeNode root) {
        if (root == null)
            return 0;

        // the min depth of left tree
        int left = solution2(root.left);
        // the min depth of right tree
        int right = solution2(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
