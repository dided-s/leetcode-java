package medium._0430_Flatten_a_Multilevel_Doubly_Linked_List;

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
    void testArguments(Node head, List<Integer> expected) {
        ListNode flatten = new Solution().flatten(head);

        List<Integer> actual = LinkedListUtils.toList(flatten);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(firstTestNode(), List.of(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6)),
                Arguments.of(secondTestNode(), List.of(1, 3, 2)),
                Arguments.of(null, List.of())
        );
    }

    static Node firstTestNode() {
        Node node11 = new Node(1);
        Node node12 = new Node(2);
        Node node13 = new Node(3);
        Node node14 = new Node(4);
        Node node15 = new Node(5);
        Node node16 = new Node(6);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;

        node12.prev = node11;
        node13.prev = node12;
        node14.prev = node13;
        node15.prev = node14;
        node16.prev = node15;

        Node node21 = new Node(7);
        Node node22 = new Node(8);
        Node node23 = new Node(9);
        Node node24 = new Node(10);

        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        node22.prev = node21;
        node23.prev = node22;
        node24.prev = node23;

        Node node31 = new Node(11);
        Node node32 = new Node(12);

        node31.next = node32;
        node32.prev = node31;

        node13.child = node21;
        node22.child = node31;

        return node11;
    }

    static Node secondTestNode() {
        Node node11 = new Node(1);
        Node node12 = new Node(2);

        node11.next = node12;
        node12.prev = node11;

        Node node21 = new Node(3);

        node11.child = node21;

        return node11;
    }
}