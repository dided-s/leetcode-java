package medium._0107_Binary_Tree_Level_Order_Traversal_II;

import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Medium
@Topic("Tree")
public class Solution2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        int size;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            size = queue.size();

            for (int i = 0; i < size; i++) {
                node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.addFirst(list);
        }

        return result;
    }
}
