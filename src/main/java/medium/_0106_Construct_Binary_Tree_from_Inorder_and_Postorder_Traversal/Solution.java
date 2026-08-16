package medium._0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import annotations.Explore;
import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

@Medium
@Explore("Binary Tree")
@Topic("Tree | Recursion")
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(
                inorder,
                postorder,
                0,
                inorder.length - 1,
                0,
                postorder.length - 1);
    }

    public TreeNode helper(
            int[] inorder,
            int[] postorder,
            int inorderStartIndex,
            int inorderEndIndex,
            int postorderStartIndex,
            int postorderEndIndex) {
        if (inorderStartIndex > inorderEndIndex || postorderStartIndex > postorderEndIndex)
            return null;
        if (inorderStartIndex == inorderEndIndex && postorderStartIndex == postorderEndIndex)
            return new TreeNode(inorder[inorderStartIndex]);

        int rootInorderIndex = inorderEndIndex;
        int postorderSplitIndex = postorderEndIndex;
        while (inorder[rootInorderIndex] != postorder[postorderEndIndex]) {
            rootInorderIndex--;
            postorderSplitIndex--;
        }
        TreeNode root = new TreeNode(postorder[postorderEndIndex]);
        root.right = helper(
                inorder,
                postorder,
                rootInorderIndex + 1,
                inorderEndIndex,
                postorderSplitIndex,
                postorderEndIndex - 1);
        root.left = helper(inorder,
                postorder,
                inorderStartIndex,
                rootInorderIndex - 1,
                postorderStartIndex,
                postorderSplitIndex - 1);
        return root;
    }
}
