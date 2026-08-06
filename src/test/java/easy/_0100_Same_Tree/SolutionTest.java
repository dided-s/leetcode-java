package easy._0100_Same_Tree;

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
    void testArguments(List<Integer> nodes1, List<Integer> nodes2, boolean expected) {
        TreeNode root1 = TreeNodeUtils.toTreeNode(nodes1);
        TreeNode root2 = TreeNodeUtils.toTreeNode(nodes2);

        boolean actual = new Solution().isSameTree(root1, root2);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), true),
                Arguments.of(Arrays.asList(1, 2), Arrays.asList(1, null, 2), false),
                Arguments.of(Arrays.asList(1, 2, 1), Arrays.asList(1, 1, 2), false)
        );
    }
}