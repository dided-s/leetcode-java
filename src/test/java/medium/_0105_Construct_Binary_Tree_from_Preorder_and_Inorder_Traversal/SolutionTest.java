package medium._0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] preorder, int[] inorder, List<Integer> expected) {
        TreeNode root = new Solution().buildTree(preorder, inorder);
        List<Integer> actual = TreeNodeUtils.toList(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{3, 9, 20, 15, 7},
                        new int[]{9, 3, 15, 20, 7},
                        Arrays.asList(3, 9, 20, null, null, 15, 7)),
                Arguments.of(
                        new int[]{-1},
                        new int[]{-1},
                        Arrays.asList(-1))
        );
    }
}