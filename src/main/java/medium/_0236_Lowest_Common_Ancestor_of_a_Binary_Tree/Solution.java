package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import annotations.Explore;
import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

@Medium
@Explore("Binary Tree")
@Topic("Tree | Recursion")
public class Solution {

    private TreeNode dfs(TreeNode root, int p, int q) {
        if (root == null) return null;

        if (p == root.val || q == root.val) return root;

        TreeNode leftSubTree = dfs(root.left, p, q);
        TreeNode rightSubTree = dfs(root.right, p, q);

        if (leftSubTree == null && rightSubTree != null) return rightSubTree;
        if (leftSubTree != null && rightSubTree == null) return leftSubTree;
        if (leftSubTree == null && rightSubTree == null) return null;
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        return dfs(root, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return root;

        if (p.left == q || p.right == q) return p;

        if (q.left == p || q.right == p) return q;

        return dfs(root, p.val, q.val);

    }
}
