package medium._0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import annotations.Explore;
import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

@Medium
@Topic("Tree | Recursion")
@Explore("Binary Tree")
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(
                preorder,
                0,
                preorder.length - 1,
                inorder,
                0,
                inorder.length - 1
        );
    }

    public TreeNode buildTree(
            int[] preorder,
            int preorderStartIndex,
            int preorderEndIndex,
            int[] inorder,
            int inorderStartIndex,
            int inorderEndIndex) {

        if (inorderStartIndex > inorderEndIndex || preorderStartIndex > preorderEndIndex) {
            return null;
        }
        if (inorderStartIndex == inorderEndIndex) {
            return new TreeNode(inorder[inorderStartIndex]);
        }

        TreeNode root = new TreeNode(preorder[preorderStartIndex]);
        int rootIndexInInorder = inorderStartIndex;
        int preorderSplitIndex = preorderStartIndex;
        while (inorder[rootIndexInInorder] != preorder[preorderStartIndex]) {
            rootIndexInInorder++;
            preorderSplitIndex++;
        }

        root.left = buildTree(
                preorder,
                preorderStartIndex + 1,
                preorderSplitIndex,
                inorder,
                inorderStartIndex,
                rootIndexInInorder - 1

        );

        root.right = buildTree(
                preorder,
                preorderSplitIndex + 1,
                preorderEndIndex,
                inorder,
                rootIndexInInorder + 1,
                inorderEndIndex
        );

        return root;
    }
}
