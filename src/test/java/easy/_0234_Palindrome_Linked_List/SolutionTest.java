package easy._0234_Palindrome_Linked_List;

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
    void testArguments(List<Integer> list, boolean expected) {
        ListNode head = LinkedListUtils.toLinkedListNode(list);

        boolean actual = new Solution().isPalindrome(head);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 2, 1), true),
                Arguments.of(List.of(1, 2, 3, 2, 1), true),
                Arguments.of(List.of(1, 2, 3, 2, 2), false),
                Arguments.of(List.of(1, 2, 3, 3, 2, 2), false),
                Arguments.of(List.of(1, 2, 1), true),
                Arguments.of(List.of(1, 2), false)
        );
    }
}