package easy._0637_Average_of_Levels_in_Binary_Tree;

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
    void testArguments(List<Integer> tree, List<Double> expected) {
        TreeNode root = TreeNodeUtils.toTreeNode(tree);
        List<Double> actual = new Solution().averageOfLevels(root);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(3, 9, 20, null, null, 15, 7),
                        Arrays.asList(3.00000, 14.50000, 11.00000)),
                Arguments.of(
                        Arrays.asList(3, 9, 20, 15, 7),
                        Arrays.asList(3.00000, 14.50000, 11.00000)),
                Arguments.of(
                        Arrays.asList(),
                        Arrays.asList()),
                Arguments.of(
                        Arrays.asList(1),
                        Arrays.asList(1.0000))
        );
    }
}