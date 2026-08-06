package easy._0144_Binary_Tree_Preorder_Traversal;

import annotations.Easy;
import annotations.Explore;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Easy
@Explore("Binary Tree")
@Topic("Recursive")
public class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);

        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}