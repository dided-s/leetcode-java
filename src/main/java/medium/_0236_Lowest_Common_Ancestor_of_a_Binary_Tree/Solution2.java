package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import annotations.Explore;
import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

@Medium
@Explore("Binary Tree")
@Topic("Tree | Recursion")
public class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestor(root, p.val, q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        Map<Integer, Boolean> cacheP = new HashMap<>();
        Map<Integer, Boolean> cacheQ = new HashMap<>();

        return lowestCommonAncestor(root, p, q, cacheP, cacheQ);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q, Map<Integer, Boolean> cacheP, Map<Integer, Boolean> cacheQ) {
        if (hasValue(root.left, p, cacheP) && hasValue(root.left, q, cacheQ)) {
            return lowestCommonAncestor(root.left, p, q, cacheP, cacheQ);
        }
        if (hasValue(root.right, p, cacheP) && hasValue(root.right, q, cacheQ)) {
            return lowestCommonAncestor(root.right, p, q, cacheP, cacheQ);
        }

        return root;
    }

    private boolean hasValue(TreeNode root, int val, Map<Integer, Boolean> cache) {
        if (root == null) return false;
        if (cache.containsKey(root.val)) return cache.get(root.val);

        if (root.val == val) return true;
        cache.put(root.val, hasValue(root.left, val, cache) || hasValue(root.right, val, cache));
        return cache.get(root.val);
    }
}
