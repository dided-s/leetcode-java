package medium._0199_Binary_Tree_Right_Side_View;

import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Medium
@Topic("Tree | Recursion")
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfc(root, 0, result);
        return result;
    }

    public void dfc(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;

        if (level == result.size()) result.add(root.val);

        dfc(root.right, level + 1, result);
        dfc(root.left, level + 1, result);
    }
}
