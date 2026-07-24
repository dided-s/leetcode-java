package medium._0148_Sort_List;

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
        ListNode sortedHead = new Solution().sortList(head);
        List<Integer> actual = LinkedListUtils.toList(sortedHead);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(4, 2, 1, 3), List.of(1, 2, 3, 4)),
                Arguments.of(List.of(-1, 5, 3, 4, 0), List.of(-1, 0, 3, 4, 5)),
                Arguments.of(List.of(-1), List.of(-1)),
                Arguments.of(List.of(2, 1), List.of(1, 2))
        );
    }
}