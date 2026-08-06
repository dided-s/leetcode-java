package easy._0100_Same_Tree;

import annotations.Easy;
import annotations.Explore;
import annotations.Topic;
import utils.TreeNode;

@Easy
@Explore("Recursion")
@Topic("Tree")
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}