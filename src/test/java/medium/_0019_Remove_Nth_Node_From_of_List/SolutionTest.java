package medium._0019_Remove_Nth_Node_From_of_List;

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
    void testArguments(List<Integer> list, int n, List<Integer> expected) {
        ListNode head = LinkedListUtils.toListNode(list);

        head = new Solution().removeNthFromEnd(head, n);

        List<Integer> actual = LinkedListUtils.toList(head);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 2, List.of(1, 2, 3, 5)),
                Arguments.of(List.of(1), 1, List.of()),
                Arguments.of(List.of(1, 2), 1, List.of(1)),
                Arguments.of(List.of(1, 2), 2, List.of(2))
        );
    }
}