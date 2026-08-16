package medium._0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

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
    void testArguments(int[] inorder, int[] postorder, List<Integer> expected) {
        TreeNode root = new Solution().buildTree(inorder, postorder);
        List<Integer> actual = TreeNodeUtils.toList(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{9, 3, 15, 20, 7},
                        new int[]{9, 15, 7, 20, 3},
                        Arrays.asList(3, 9, 20, null, null, 15, 7)),
                Arguments.of(
                        new int[]{-1},
                        new int[]{-1},
                        Arrays.asList(-1)),
                Arguments.of(
                        new int[]{3, 2, 6, 17, 1, 7, 5, 9, 8, 4, 10, 14, 13, 11, 20, 15, 19},
                        new int[]{6, 2, 1, 7, 17, 3, 8, 9, 5, 14, 13, 20, 19, 15, 11, 10, 4},
                        Arrays.asList(4, 5, 10, 3, 9, null, 11, null, 17, null, 8, 13, 15, 2, 7, null, null, 14, null, 20, 19, null, 6, 1)),
                Arguments.of(
                        new int[]{4, 2, 5, 6, 1, 3, 8, 9, 7, 10},
                        new int[]{4, 5, 6, 2, 9, 8, 10, 7, 3, 1},
                        Arrays.asList(1, 2, 3, 4, 6, null, 7, null, null, 5, null, 8, 10, null, null, null, 9)),
                Arguments.of(
                        new int[]{10, 9, 3, 11, 15, 20, 7},
                        new int[]{10, 9, 11, 15, 7, 20, 3},
                        Arrays.asList(3, 9, 20, 10, null, 15, 7, null, null, 11))
        );
    }
}