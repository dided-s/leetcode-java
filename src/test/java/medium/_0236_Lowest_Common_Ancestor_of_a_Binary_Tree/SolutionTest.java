package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

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
    void testArguments(List<Integer> nodes, int p, int q, int expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(nodes);

        TreeNode node = new Solution().lowestCommonAncestor(root, p, q);

        Assertions.assertEquals(expected, node.val);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4),
                        5, 1, 3
                ),
                Arguments.of(
                        Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4),
                        5, 4, 5
                ),
                Arguments.of(
                        Arrays.asList(1, 2),
                        1, 2, 1
                ),
                Arguments.of(
                        Arrays.asList(1, 2, 3, null, 4),
                        4, 1, 1
                )
        );
    }
}