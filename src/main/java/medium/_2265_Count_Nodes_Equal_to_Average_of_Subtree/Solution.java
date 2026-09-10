package medium._2265_Count_Nodes_Equal_to_Average_of_Subtree;

import annotations.Explore;
import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

@Medium
@Topic("Recursion")
@Explore("Binary Tree")
public class Solution {

    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        averageOfSubtreeRecursion(root);
        return count;
    }

    public int[] averageOfSubtreeRecursion(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = averageOfSubtreeRecursion(node.left);
        int[] right = averageOfSubtreeRecursion(node.right);

        int[] result = new int[]{node.val + left[0] + right[0], 1 + left[1] + right[1]};
        if (result[1] != 0 && node.val == result[0] / result[1]) {
            count++;
        }

        return result;
    }
}