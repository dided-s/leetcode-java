package medium._0707_Design_Linked_List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    void test() {
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(1);
        Assertions.assertEquals(1, list.get(0));

        list.addAtTail(2);
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, list.get(0)),
                () -> Assertions.assertEquals(2, list.get(1))
        );

        list.addAtHead(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, list.get(0)),
                () -> Assertions.assertEquals(1, list.get(1)),
                () -> Assertions.assertEquals(2, list.get(2))
        );

        list.addAtIndex(1, 4);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, list.get(0)),
                () -> Assertions.assertEquals(4, list.get(1)),
                () -> Assertions.assertEquals(1, list.get(2)),
                () -> Assertions.assertEquals(2, list.get(3))
        );

        list.addAtTail(5);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, list.get(0)),
                () -> Assertions.assertEquals(4, list.get(1)),
                () -> Assertions.assertEquals(1, list.get(2)),
                () -> Assertions.assertEquals(2, list.get(3)),
                () -> Assertions.assertEquals(5, list.get(4))
        );

        list.deleteAtIndex(1);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, list.get(0)),
                () -> Assertions.assertEquals(1, list.get(1)),
                () -> Assertions.assertEquals(2, list.get(2)),
                () -> Assertions.assertEquals(5, list.get(3))
        );

        list.deleteAtIndex(1);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, list.get(0)),
                () -> Assertions.assertEquals(2, list.get(1)),
                () -> Assertions.assertEquals(5, list.get(2))
        );

        list.deleteAtIndex(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, list.get(0)),
                () -> Assertions.assertEquals(5, list.get(1))
        );

        list.deleteAtIndex(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(5, list.get(0))
        );

        list.deleteAtIndex(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(-1, list.get(0))
        );

        list.addAtIndex(0, 0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, list.get(0))
        );

        list.addAtIndex(1, 1);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, list.get(0)),
                () -> Assertions.assertEquals(1, list.get(1))
        );
    }
}