package easy._0700_Search_in_a_Binary_Search_Tree;

import annotations.Easy;
import annotations.Explore;
import annotations.Topic;
import utils.TreeNode;

@Easy
@Explore("Recursion")
@Topic("Tree")
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        if (left != null) return left;
        return searchBST(root.right, val);
    }
}