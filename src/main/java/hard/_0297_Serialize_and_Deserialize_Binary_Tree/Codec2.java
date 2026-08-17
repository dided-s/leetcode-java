package hard._0297_Serialize_and_Deserialize_Binary_Tree;

import annotations.Explore;
import annotations.Hard;
import annotations.Topic;
import utils.TreeNode;

import java.util.*;

@Hard
@Explore("Binary Tree")
@Topic("Tree")
public class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> nodes = toList(root);
        return toString(nodes);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> nodes = toList(data);

        return toTreeNode(nodes);
    }

    private List<Integer> toList(String data) {
        List<Integer> result = new ArrayList<>();
        if (data == null) return result;
        if (data.trim().length() == 0) return result;
        String[] tokens = data.split(",");

        for (String token : tokens) {
            if (token.trim().equals("null")) {
                result.add(null);
            } else {
                result.add(Integer.valueOf(token));
            }
        }

        return result;
    }

    private String toString(List<Integer> list) {
        if (list == null || list.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        for (Integer i : list) {
            result.append(i);
            result.append(",");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private TreeNode toTreeNode(List<Integer> list) {
        return toTreeNode(list.toArray(new Integer[list.size()]));
    }

    private TreeNode toTreeNode(Integer[] array) {
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

    private List<Integer> toList(TreeNode root) {
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