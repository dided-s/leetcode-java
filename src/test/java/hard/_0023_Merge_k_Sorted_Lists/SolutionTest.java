package hard._0023_Merge_k_Sorted_Lists;

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
    void testArguments(List<List<Integer>> ls, List<Integer> expected) {
        ListNode[] lists = ls.stream().map(LinkedListUtils::toLinkedListNode).toArray(ListNode[]::new);

        ListNode head = new Solution().mergeKLists(lists);
        List<Integer> actual = LinkedListUtils.toList(head);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(1, 4, 5),
                                List.of(1, 3, 4),
                                List.of(2, 6)
                        ),
                        List.of(1, 1, 2, 3, 4, 4, 5, 6)
                ),
                Arguments.of(
                        List.of(),
                        List.of()
                ),
                Arguments.of(
                        List.of(List.of()),
                        List.of()
                )
        );
    }
}