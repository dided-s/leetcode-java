package easy._0021_Merge_Two_Sorted_Lists;

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
        ListNode head1 = LinkedListUtils.toLinkedListNode(list1);
        ListNode head2 = LinkedListUtils.toLinkedListNode(list2);

        ListNode mergeNode = new Solution().mergeTwoLists(head1, head2);
        List<Integer> actual = LinkedListUtils.toList(mergeNode);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 4), List.of(1, 3, 4), List.of(1, 1, 2, 3, 4, 4)),
                Arguments.of(List.of(), List.of(), List.of()),
                Arguments.of(List.of(0), List.of(), List.of(0)),
                Arguments.of(List.of(), List.of(0), List.of(0))
        );
    }
}