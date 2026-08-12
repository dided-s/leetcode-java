package easy._0102_Binary_Tree_Level_Order_Traversal;

import annotations.Easy;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Easy
@Topic("Tree | Recursion")
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> list = new ArrayList<>();
        recursion(root, 0, list);

        return list;
    }

    public void recursion(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        // add current node to current level
        result.get(level).add(root.val);

        recursion(root.left, level + 1, result);
        recursion(root.right, level + 1, result);
    }
}