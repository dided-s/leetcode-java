package hard._0297_Serialize_and_Deserialize_Binary_Tree;

import annotations.Explore;
import annotations.Hard;
import annotations.Topic;
import utils.TreeNode;

@Hard
@Explore("Binary Tree")
@Topic("Tree")
public class Codec {

    private int index;

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }

        sb.append(node.val).append(',');
        encode(node.left, sb);
        encode(node.right, sb);
    }


    // Deserialize
    public TreeNode deserialize(String data) {
        index = 0;
        return decode(data);
    }

    private TreeNode decode(String data) {

        if (data.charAt(index) == '#') {
            index += 2; // skip "#,"
            return null;
        }

        int num = 0;
        boolean negative = false;

        if (data.charAt(index) == '-') {
            negative = true;
            index++;
        }

        while (data.charAt(index) != ',') {
            num = num * 10 + (data.charAt(index) - '0');
            index++;
        }

        index++; // skip comma

        if (negative)
            num = -num;

        TreeNode node = new TreeNode(num);

        node.left = decode(data);
        node.right = decode(data);

        return node;
    }
}