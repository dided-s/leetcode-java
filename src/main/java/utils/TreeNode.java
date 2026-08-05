package utils;

public class TreeNode extends GeneralTreeNode<TreeNode> {

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        super(TreeNode.class, 2, val);

        getChildren()[0] = this.left;
        getChildren()[1] = this.right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        super(TreeNode.class, 2, val);

        this.left = left;
        this.right = right;

        getChildren()[0] = this.left;
        getChildren()[1] = this.right;
    }
}