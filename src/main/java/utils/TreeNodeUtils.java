package utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils {

    public static TreeNode toTreeNode(List<Integer> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return null;
        }

        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < list.size()) {
            TreeNode node = queue.poll();

            if (i < list.size() && list.get(i) != null) {
                node.left = new TreeNode(list.get(i));
                queue.offer(node.left);
            }
            i++;

            if (i < list.size() && list.get(i) != null) {
                node.right = new TreeNode(list.get(i));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    public static List<Integer> toList(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return list;
    }
}