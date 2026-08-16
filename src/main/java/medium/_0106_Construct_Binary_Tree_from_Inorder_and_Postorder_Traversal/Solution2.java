package medium._0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import annotations.Explore;
import annotations.Medium;
import annotations.Topic;
import utils.TreeNode;

@Medium
@Topic("Tree | Recursion")
@Explore("Binary Tree")
public class Solution2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(
                inorder,
                0,
                inorder.length - 1,
                postorder,
                0,
                postorder.length - 1);
    }

    public TreeNode buildTree(
            int[] inorder,
            int inorderStartIndex,
            int inorderEndIndex,
            int[] postorder,
            int postorderStartIndex,
            int postorderEndIndex) {

        if (inorderStartIndex > inorderEndIndex) {
            return null;
        }
        if (inorderStartIndex == inorderEndIndex) {
            return new TreeNode(inorder[inorderStartIndex]);
        }

        TreeNode root = new TreeNode(postorder[postorderEndIndex]);

        int rootIndexInInorder = findRootIndexInInorder(root.val, inorder, inorderStartIndex, inorderEndIndex);
        if (rootIndexInInorder == -1) {
            return root;
        }
        int leftSize = rootIndexInInorder - inorderStartIndex;

        root.left = buildTree(
                inorder,
                inorderStartIndex,
                rootIndexInInorder - 1,
                postorder,
                postorderStartIndex,
                postorderStartIndex + leftSize - 1
        );


        root.right = buildTree(
                inorder,
                rootIndexInInorder + 1,
                inorderEndIndex,
                postorder,
                postorderStartIndex + leftSize,
                postorderEndIndex - 1
        );

        return root;
    }

    private int findRootIndexInInorder(
            int rootVal,
            int[] inorder,
            int leftStartIndex,
            int leftEndIndex) {
        int index = leftStartIndex;

        while (index <= leftEndIndex) {
            if (inorder[index] == rootVal) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
