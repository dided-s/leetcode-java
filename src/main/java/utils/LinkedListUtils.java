package utils;

import java.util.ArrayList;
import java.util.List;

public class LinkedListUtils {

    public static ListNode toLinkedListNode(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));

        ListNode current = head;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }

        return head;
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }
}