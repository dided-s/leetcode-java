package medium._0138_Copy_List_with_Random_Pointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    void test() {
        Node head = firstTestNode();

        Node copy = new Solution().copyRandomList(head);
        Assertions.assertNotSame(head, copy);

        List<Node> copyList = new ArrayList<>();
        while (copy != null) {
            copyList.add(copy);
            copy = copy.next;
        }

        Assertions.assertSame(copyList.get(1).random, copyList.get(0));
        Assertions.assertSame(copyList.get(2).random, copyList.get(4));
        Assertions.assertSame(copyList.get(3).random, copyList.get(2));
        Assertions.assertSame(copyList.get(4).random, copyList.get(0));
    }

    static Node firstTestNode() {
        Node node11 = new Node(7);
        Node node12 = new Node(13);
        Node node13 = new Node(11);
        Node node14 = new Node(10);
        Node node15 = new Node(1);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        node12.random = node11;
        node13.random = node15;
        node14.random = node13;
        node15.random = node11;

        return node11;
    }
}