package medium._0095_Unique_Binary_Search_Trees_II;

import annotations.Explore;
import annotations.Medium;
import utils.TreeNode;

import java.util.*;

@Medium
@Explore("Recursion I")
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> cache = new HashMap<>();

        return generateTrees(1, n, cache);
    }

    public List<TreeNode> generateTrees(int left, int right, Map<Pair<Integer, Integer>, List<TreeNode>> cache) {
        List<TreeNode> result = new ArrayList<>();

        if (left > right) {
            result.add(null);
            return result;
        }

        if (cache.containsKey(new Pair<>(left, right))) {
            return cache.get(new Pair<>(left, right));
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTreeNodes = generateTrees(left, i - 1, cache);
            List<TreeNode> rightTreeNodes = generateTrees(i + 1, right, cache);

            for (TreeNode leftTreeNode : leftTreeNodes) {
                for (TreeNode rightTreeNode : rightTreeNodes) {
                    TreeNode root = new TreeNode(i, leftTreeNode, rightTreeNode);
                    result.add(root);
                }
            }
        }

        cache.put(new Pair<>(left, right), result);

        return result;
    }

    private static class Pair<FIRST, SECOND> {
        public FIRST first;
        public SECOND second;

        public Pair(FIRST first, SECOND second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Pair<?, ?> pair)) return false;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}