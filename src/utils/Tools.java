package utils;

import java.util.Queue;
import java.util.LinkedList;
//import utils.TreeNode;

/**
 * A TOOL class that help for testing
 */
public class Tools {
    public static TreeNode intArrayToTree(int[] input) {
        if (input.length == 0)
            return null;

        int item = input[0];
        TreeNode root = new TreeNode(item);
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if (index == input.length)
                break;

            item = input[index++];
            if (item != Integer.MAX_VALUE) {
                node.left = new TreeNode(item);
                nodeQueue.add(node.left);
            }

            if (index == input.length)
                break;

            item = input[index++];
            if (item != Integer.MAX_VALUE) {
                node.right = new TreeNode(item);
                nodeQueue.add(node.right);
            }
        }

        return root;

    }
}
