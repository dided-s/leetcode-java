package medium._0082_Remove_Duplicates_from_Sorted_List_II;

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
        ListNode head = LinkedListUtils.toLinkedListNode(list);

        ListNode deleteDuplicates = new Solution().deleteDuplicates(head);
        List<Integer> actual = LinkedListUtils.toList(deleteDuplicates);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 3, 4, 4, 5), List.of(1, 2, 5)),
                Arguments.of(List.of(1, 1, 1, 2, 3), List.of(2, 3)),
                Arguments.of(List.of(1, 2, 2), List.of(1))
        );
    }
}