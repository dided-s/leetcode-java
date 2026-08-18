package medium._0199_Binary_Tree_Right_Side_View;

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
    void testArguments(List<Integer> nodes, List<Integer> expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(nodes);
        List<Integer> actual = new Solution().rightSideView(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, null, 5, null, 4),
                        Arrays.asList(1, 3, 4)),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, null, null, null, 5),
                        Arrays.asList(1, 3, 4, 5)),
                Arguments.of(
                        Arrays.asList(1, null, 3),
                        Arrays.asList(1, 3)),
                Arguments.of(
                        Arrays.asList(),
                        Arrays.asList())
        );
    }
}