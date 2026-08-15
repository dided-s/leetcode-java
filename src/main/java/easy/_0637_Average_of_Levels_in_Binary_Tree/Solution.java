package easy._0637_Average_of_Levels_in_Binary_Tree;

import annotations.Easy;
import annotations.Explore;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Easy
@Explore("Binary Tree")
public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return List.of();
        List<Double> result = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        sumAndSize(root, 0, result, sizes);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / sizes.get(i));
        }

        return result;
    }

    private void sumAndSize(TreeNode node, int level, List<Double> sums, List<Integer> sizes) {
        if (node == null) return;
        if (level == sizes.size()) {
            sums.add(0.0);
            sizes.add(0);
        }

        sums.set(level, sums.get(level) + node.val);
        sizes.set(level, sizes.get(level) + 1);

        sumAndSize(node.left, level + 1, sums, sizes);
        sumAndSize(node.right, level + 1, sums, sizes);
    }
}