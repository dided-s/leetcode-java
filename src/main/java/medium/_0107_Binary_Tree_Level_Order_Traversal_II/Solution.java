package medium._0107_Binary_Tree_Level_Order_Traversal_II;

import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Medium
@Topic("Tree | Recursion")
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> list = new ArrayList<>();
        int depth = getDepth(root);
        for (int i = 0; i < depth; i++) {
            list.add(new ArrayList<>());
        }

        recursion(root, 0, depth, list);

        return list;
    }

    public void recursion(TreeNode node, int level, int maxDepth, List<List<Integer>> result) {
        if (node == null) return;

        // Map root-level index directly to its bottom-up target index
        int index = maxDepth - 1 - level;
        result.get(index).add(node.val);

        recursion(node.left, level + 1, maxDepth, result);
        recursion(node.right, level + 1, maxDepth, result);
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
}
