package easy._0637_Average_of_Levels_in_Binary_Tree;

import annotations.Easy;
import annotations.Explore;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Easy
@Explore("Binary Tree")
@Topic("Recursion")
public class Solution2 {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return List.of();

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        TreeNode node;

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;

            for (int i = 0; i < size; i++) {
                node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(sum / size);
        }

        return result;
    }
}