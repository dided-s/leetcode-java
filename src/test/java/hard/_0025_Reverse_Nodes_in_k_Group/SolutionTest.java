package hard._0025_Reverse_Nodes_in_k_Group;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedListUtils;
import utils.ListNode;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(List<Integer> list, int k, List<Integer> expected) {
        ListNode head = LinkedListUtils.toLinkedListNode(list);

        ListNode reverseK = new Solution().reverseKGroup(head, k);
        List<Integer> actual = LinkedListUtils.toList(reverseK);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 2, List.of(2, 1, 4, 3, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 3, List.of(3, 2, 1, 4, 5))
        );
    }
}