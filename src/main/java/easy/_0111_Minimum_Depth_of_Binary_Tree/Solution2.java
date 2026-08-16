package easy._0111_Minimum_Depth_of_Binary_Tree;

import annotations.Easy;
import annotations.Topic;
import utils.TreeNode;

@Easy
@Topic("Tree")
public class Solution2 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return minDepth(root, 1);
    }

    private int minDepth(TreeNode node, int min) {
        if (node.left == null && node.right == null) return min;
        if (node.left == null) return minDepth(node.right, min + 1);
        if (node.right == null) return minDepth(node.left, min + 1);

        return Math.min(minDepth(node.left, min + 1), minDepth(node.right, min + 1));
    }
}