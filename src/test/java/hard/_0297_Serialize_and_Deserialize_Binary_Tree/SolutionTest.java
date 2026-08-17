package hard._0297_Serialize_and_Deserialize_Binary_Tree;

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
    void testArguments(List<Integer> nodes) {
        TreeNode root = TreeNodeUtils.toTreeNode(nodes);

        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        System.out.println(serialized);
        TreeNode result = codec.deserialize(serialized);

        List<Integer> actual = TreeNodeUtils.toList(result);

        Assertions.assertEquals(nodes, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, null, null, 4, 5)
                ),
                Arguments.of(
                        Arrays.asList()
                ),
                Arguments.of(
                        Arrays.asList(1)
                )
        );
    }
}