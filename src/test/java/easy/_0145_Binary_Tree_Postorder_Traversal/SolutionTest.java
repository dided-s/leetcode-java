package easy._0145_Binary_Tree_Postorder_Traversal;

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
        List<Integer> actual = new Solution().postorderTraversal(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, null, 2, 3),
                        Arrays.asList(3, 2, 1)),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9),
                        Arrays.asList(4, 6, 7, 5, 2, 9, 8, 3, 1)),
                Arguments.of(
                        Arrays.asList(),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList(1),
                        Arrays.asList(1))
        );
    }
}