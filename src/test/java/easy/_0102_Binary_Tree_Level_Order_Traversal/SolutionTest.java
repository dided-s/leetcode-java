package easy._0102_Binary_Tree_Level_Order_Traversal;

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
    void testArguments(List<Integer> tree, List<List<Integer>> expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(tree);

        List<List<Integer>> actual = new Solution().levelOrder(root);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(3, 9, 20, null, null, 15, 7),
                        Arrays.asList(List.of(3), List.of(9, 20), List.of(15, 7))),
                Arguments.of(
                        Arrays.asList(),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList(1),
                        Arrays.asList(List.of(1)))
        );
    }
}