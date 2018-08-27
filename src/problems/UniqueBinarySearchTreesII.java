package problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 95: Unique Binary Search Trees II
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> solution(int n) {
        // result[i] stores the result until length i.
        // For the result for length i+1, select the root node j from 0 to i,
        // combine the result from left side and right side.
        // Note for the right side we have to clone the nodes as the value will be offsetted by j.
        ArrayList<List<TreeNode>> resList = new ArrayList<List<TreeNode>>(n+1);
        resList.add(new ArrayList<TreeNode>());
        if (n == 0)
            return resList.get(0);

        resList.get(0).add(null);
        for (int len = 1; len <= n; len++) {
            resList.add(new ArrayList<TreeNode>());
            for (int i = 0; i < len; i++) {
                for (TreeNode nodeL : resList.get(i)) {
                    for (TreeNode nodeR : resList.get(len - i - 1)) {
                        TreeNode node = new TreeNode(i+1);
                        node.left = nodeL;
                        node.right = clone(nodeR, i+1);
                        resList.get(len).add(node);
                    }
                }
            }
        }

        return resList.get(n);
    }

    // clone the right tree with offset from existed result.
    private TreeNode clone(TreeNode node, int offset) {
        if (node == null)
            return null;

        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = clone(node.left, offset);
        newNode.right = clone(node.right, offset);

        return newNode;
    }
}
