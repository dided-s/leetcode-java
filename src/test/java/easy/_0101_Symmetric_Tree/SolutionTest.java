package easy._0101_Symmetric_Tree;

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
    void testArguments(List<Integer> nodes, boolean expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(nodes);
        boolean actual = new Solution().isSymmetric(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 2, 3, 4, 4, 3), true),
                Arguments.of(Arrays.asList(1, 2, 2, null, 3, null, 3), false)
        );
    }
}