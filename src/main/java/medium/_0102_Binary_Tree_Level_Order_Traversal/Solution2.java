package medium._0102_Binary_Tree_Level_Order_Traversal;

import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Medium
@Topic("Tree")
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> answer = new ArrayList<>();
        TreeNode lastLeverNode = root;
        TreeNode nextLeverNode = root;
        TreeNode node = root;

        while (lastLeverNode != null) {
            List<Integer> level = new ArrayList<>();

            while (true) {
                node = queue.poll();
                if (node == null) {
                    break;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    nextLeverNode = node.left;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLeverNode = node.right;
                }

                level.add(node.val);

                if (node == lastLeverNode) {
                    break;
                }
            }

            if (level.size() != 0) {
                answer.add(level);
            }
            lastLeverNode = nextLeverNode;
            nextLeverNode = null;
        }

        return answer;
    }
}