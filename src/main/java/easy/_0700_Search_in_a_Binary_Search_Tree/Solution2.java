package easy._0700_Search_in_a_Binary_Search_Tree;

import annotations.Easy;
import annotations.Explore;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@Easy
@Explore("Recursion")
@Topic("Tree")
public class Solution2 {

    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.val == val) return node;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return null;
    }
}