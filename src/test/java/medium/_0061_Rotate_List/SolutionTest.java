package medium._0061_Rotate_List;

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
    void testArguments(List<Integer> list, int k, List<Integer> expected) {
        ListNode head = LinkedListUtils.toListNode(list);

        ListNode rotateK = new Solution().rotateRight(head, k);
        List<Integer> actual = LinkedListUtils.toList(rotateK);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 2, List.of(4, 5, 1, 2, 3)),
                Arguments.of(List.of(0, 1, 2), 4, List.of(2, 0, 1))
        );
    }
}