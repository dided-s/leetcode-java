package medium._0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import annotations.Explore;
import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

@Medium
@Topic("Tree | Recursion")
@Explore("Binary Tree")
public class Solution2 {

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

        if (inorderStartIndex > inorderEndIndex) {
            return null;
        }
        if (inorderStartIndex == inorderEndIndex) {
            return new TreeNode(inorder[inorderStartIndex]);
        }

        TreeNode root = new TreeNode(preorder[preorderStartIndex]);
        int rootIndexInInorder = findRootIndexInInorder(root.val, inorder, inorderStartIndex, inorderEndIndex);
        if (rootIndexInInorder == -1) {
            return root;
        }
        int leftSize = rootIndexInInorder - inorderStartIndex;

        root.left = buildTree(
                preorder,
                preorderStartIndex + 1,
                preorderStartIndex + leftSize,
                inorder,
                inorderStartIndex,
                rootIndexInInorder - 1

        );

        root.right = buildTree(
                preorder,
                preorderStartIndex + leftSize + 1,
                preorderEndIndex,
                inorder,
                rootIndexInInorder + 1,
                inorderEndIndex
        );

        return root;
    }

    private int findRootIndexInInorder(
            int rootVal,
            int[] inorder,
            int inorderStartIndex,
            int inorderEndIndex) {
        int index = inorderStartIndex;

        while (index <= inorderEndIndex) {
            if (inorder[index] == rootVal) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
