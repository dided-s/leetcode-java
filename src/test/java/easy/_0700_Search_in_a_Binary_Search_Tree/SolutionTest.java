package easy._0700_Search_in_a_Binary_Search_Tree;

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
    void testArguments(List<Integer> nodes, int val, List<Integer> expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(nodes);

        TreeNode actual = new Solution().searchBST(root, val);
        Assertions.assertEquals(expected, TreeNodeUtils.toList(actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(Arrays.asList(4, 2, 7, 1, 3), 2, List.of(2, 1, 3)),
                Arguments.of(Arrays.asList(4, 2, 7, 1, 3), 5, List.of()),
                Arguments.of(Arrays.asList(4, 2, 7, 1, 3, null), 5, List.of())
        );
    }
}