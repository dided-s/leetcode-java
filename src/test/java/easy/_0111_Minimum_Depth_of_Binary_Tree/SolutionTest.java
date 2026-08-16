package easy._0111_Minimum_Depth_of_Binary_Tree;

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
    void testArguments(List<Integer> nodes, int expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(nodes);

        int actual = new Solution().minDepth(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(Arrays.asList(3, 9, 20, null, null, 15, 7), 2),
                Arguments.of(Arrays.asList(2, null, 3, null, 4, null, 5, null, 6), 5)
        );
    }
}