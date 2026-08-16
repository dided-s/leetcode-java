package easy._0112_Path_Sum;

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
    void testArguments(List<Integer> nodes, int targetSum, boolean expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(nodes);

        boolean actual = new Solution().hasPathSum(root, targetSum);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22, true),
                Arguments.of(Arrays.asList(1, 2, 3), 5, false),
                Arguments.of(Arrays.asList(), 0, false),
                Arguments.of(Arrays.asList(1, 2), 1, false),
                Arguments.of(Arrays.asList(10, 2, 11, 0), 12, true)
        );
    }
}