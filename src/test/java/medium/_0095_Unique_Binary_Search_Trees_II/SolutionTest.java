package medium._0095_Unique_Binary_Search_Trees_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, Set<List<Integer>> expected) {
        List<TreeNode> treeNodeList = new Solution().generateTrees(n);

        Set<List<Integer>> actual = treeNodeList.stream()
                .map(TreeNodeUtils::toList)
                .collect(Collectors.toSet());

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(3,
                        Set.of(
                                Arrays.asList(1, null, 2, null, 3),
                                Arrays.asList(1, null, 3, 2),
                                Arrays.asList(2, 1, 3),
                                Arrays.asList(3, 1, null, null, 2),
                                Arrays.asList(3, 2, null, 1)
                        )),
                Arguments.of(1,
                        Set.of(
                                Arrays.asList(1)
                        )
                ));
    }
}