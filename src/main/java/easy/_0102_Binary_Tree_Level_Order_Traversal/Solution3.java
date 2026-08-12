package easy._0102_Binary_Tree_Level_Order_Traversal;

import annotations.Easy;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Easy
@Topic("Tree")
public class Solution3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        TreeNode node = root;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}