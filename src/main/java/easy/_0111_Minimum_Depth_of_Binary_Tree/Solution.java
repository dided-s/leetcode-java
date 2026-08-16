package easy._0111_Minimum_Depth_of_Binary_Tree;

import annotations.Easy;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@Easy
@Topic("Tree")
public class Solution {

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int depth = 1;
        TreeNode node;
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();

                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}