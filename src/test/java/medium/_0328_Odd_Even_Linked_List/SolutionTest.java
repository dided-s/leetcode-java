package medium._0328_Odd_Even_Linked_List;

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

        head = new Solution().oddEvenList(head);

        List<Integer> actual = LinkedListUtils.toList(head);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), List.of(1, 3, 5, 2, 4)),
                Arguments.of(List.of(2, 1, 3, 5, 6, 4, 7), List.of(2, 3, 6, 7, 1, 5, 4))
        );
    }
}