package utils;

import java.util.*;

public class TreeNodeUtils {

    public static TreeNode toTreeNode(List<Integer> list) {
        return toTreeNode(list.toArray(new Integer[list.size()]));
    }

    public static TreeNode toTreeNode(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode node = queue.poll();

            if (i < array.length && array[i] != null) {
                node.left = new TreeNode(array[i]);
                queue.offer(node.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                node.right = new TreeNode(array[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    public static List<Integer> toList(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();

        Queue<Optional<TreeNode>> queue = new ArrayDeque<>();
        queue.offer(Optional.ofNullable(root));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll().orElse(null);

            if (node != null) {
                list.add(node.val);
            } else {
                list.add(null);
                continue;
            }

            queue.offer(Optional.ofNullable(node.left));
            queue.offer(Optional.ofNullable(node.right));
        }

        while (list.getLast() == null) {
            list.removeLast();
        }

        return list;
    }
}