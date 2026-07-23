package medium._0002_Add_Two_Numbers;

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
    void testArguments(List<Integer> list1, List<Integer> list2, List<Integer> expected) {
        ListNode head1 = LinkedListUtils.toListNode(list1);
        ListNode head2 = LinkedListUtils.toListNode(list2);

        ListNode head = new Solution().addTwoNumbers(head1, head2);
        List<Integer> actual = LinkedListUtils.toList(head);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(2, 4, 3), List.of(5, 6, 4), List.of(7, 0, 8)),
                Arguments.of(List.of(0), List.of(0), List.of(0)),
                Arguments.of(List.of(9, 9, 9, 9, 9, 9, 9), List.of(9, 9, 9, 9), List.of(8, 9, 9, 9, 0, 0, 0, 1))
        );
    }
}