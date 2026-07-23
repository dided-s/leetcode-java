package medium._0024_Swap_Nodes_in_Pairs;

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
    void testArguments(List<Integer> list, List<Integer> expected) {
        ListNode head = LinkedListUtils.toListNode(list);

        ListNode swapPairs = new Solution().swapPairs(head);
        List<Integer> actual = LinkedListUtils.toList(swapPairs);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), List.of(2, 1, 4, 3)),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(1), List.of(1)),
                Arguments.of(List.of(1, 2, 3), List.of(2, 1, 3))
        );
    }
}