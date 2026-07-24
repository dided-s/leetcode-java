package medium._0143_Reorder_List;

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
        new Solution().reorderList(head);

        List<Integer> actual = LinkedListUtils.toList(head);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), List.of(1, 5, 2, 4, 3)),
                Arguments.of(List.of(1, 2, 3, 4), List.of(1, 4, 2, 3))
        );
    }
}