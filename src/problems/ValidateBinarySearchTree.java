package problems;

import utils.TreeNode;

import java.util.ArrayList;

/**
 * Created by winters on 2018/7/10.
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
            if (root.right.val <= root.val || !isValidBST(root.left, rightList))
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
