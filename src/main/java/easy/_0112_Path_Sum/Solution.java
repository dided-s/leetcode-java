package easy._0112_Path_Sum;

import annotations.Easy;
import annotations.Topic;
import utils.TreeNode;

@Easy
@Topic("Tree")
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return currentSum + root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum, currentSum + root.val) ||
                hasPathSum(root.right, targetSum, currentSum + root.val);
    }
}