package medium._0092_Reverse_Linked_List_II;

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
    void testArguments(List<Integer> list, int leftNumber, int rightNumber, List<Integer> expected) {
        ListNode head = LinkedListUtils.toListNode(list);
        ListNode newHead = new Solution().reverseBetween(head, leftNumber, rightNumber);

        List<Integer> actual = LinkedListUtils.toList(newHead);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 2, 4, List.of(1, 4, 3, 2, 5)),
                Arguments.of(List.of(5), 1, 1, List.of(5)),
                Arguments.of(List.of(4, 5), 1, 1, List.of(4, 5)),
                Arguments.of(List.of(3, 5), 1, 2, List.of(5, 3)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 1, 3, List.of(3, 2, 1, 4, 5))
        );
    }
}