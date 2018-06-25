package problems;

import utils.TreeNode;
import java.util.List;
import java.util.ArrayList;

/**
 * problem 113: Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * note: a leaf is a node with no children.
 *
 * example:
 *
 * given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 *
 * return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    private List<List<Integer>> resultList;
    private int SUM;

    public List<List<Integer>> solution(TreeNode root, int sum) {
        this.SUM = sum;
        this.resultList = new ArrayList<List<Integer>>();
        ArrayList<Integer> pathList = new ArrayList<Integer>();
        this.getAns(root, pathList, 0);
        return this.resultList;
    }

    public void getAns(TreeNode tn, ArrayList<Integer> pathList, int pathSum) {
        if (tn == null)
            return;

        pathSum += tn.val;
        pathList.add(tn.val);
        if (tn.left == null && tn.right == null && pathSum == this.SUM) {
            ArrayList<Integer> curList = (ArrayList<Integer>) pathList.clone();
            this.resultList.add(curList);
        }
        if (tn.left != null)
            this.getAns(tn.left, pathList, pathSum);

        if (tn.right != null)
            this.getAns(tn.right, pathList, pathSum);

        pathList.remove(pathList.size() - 1);
    }
}
