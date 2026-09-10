package medium._2265_Count_Nodes_Equal_to_Average_of_Subtree;

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
    void testArguments(List<Integer> tree, int expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(tree);
        int actual = new Solution().averageOfSubtree(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(4, 8, 5, 0, 1, null, 6),
                        5),
                Arguments.of(
                        Arrays.asList(1),
                        1)
        );
    }
}