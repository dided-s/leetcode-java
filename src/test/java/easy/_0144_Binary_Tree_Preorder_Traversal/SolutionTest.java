package easy._0144_Binary_Tree_Preorder_Traversal;

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
    void testArguments(List<Integer> tree, List<Integer> expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(tree);
        List<Integer> actual = new Solution().preorderTraversal(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, null, 2, 3),
                        Arrays.asList(1, 2, 3)),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9),
                        Arrays.asList(1, 2, 4, 5, 6, 7, 3, 8, 9)),
                Arguments.of(
                        Arrays.asList(),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList(1),
                        Arrays.asList(1))
        );
    }
}