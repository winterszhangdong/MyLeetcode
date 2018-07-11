package problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 102: Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root != null)
            traversal(root, 0, resultList);
        return resultList;
    }

    private void traversal(TreeNode root, int level, ArrayList<List<Integer>> resultList) {
        if (level >= resultList.size()) {
            for (int i = resultList.size(); i <= level; i++)
                resultList.add(new ArrayList<Integer>());
        }

        resultList.get(level).add(root.val);

        if (root.left != null)
            traversal(root.left, level+1, resultList);
        if (root.right != null)
            traversal(root.right, level+1, resultList);
    }
}
