package problems;

import utils.TreeNode;

/**
 * problem 101: Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || check(root.left, root.right);
    }

    private boolean check(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        else if (r1 != null && r2 != null) {
            return r1.val == r2.val && check(r1.left, r2.right) && check(r1.right, r2.left);
        }
        else
            return false;
    }
}
