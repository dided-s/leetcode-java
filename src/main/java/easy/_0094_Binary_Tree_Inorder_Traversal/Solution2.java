package easy._0094_Binary_Tree_Inorder_Traversal;

import annotations.Easy;
import annotations.Explore;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Easy
@Explore("Binary Tree")
@Topic("Recursion")
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderTraversal(root, result);

        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}