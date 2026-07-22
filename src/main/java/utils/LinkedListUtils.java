package utils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class LinkedListUtils {

    public static ListNode toLinkedListNode(List<Integer> list) {
        if (list == null || list.size() == 0) return null;

        ListNode head = new ListNode(list.get(0));

        ListNode current = head;
        for (int i = 1; i < list.size(); i++) {
            current.setNext(new ListNode(list.get(i)));
            current = current.getNext();
        }

        return head;
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.getVal());
            head = head.getNext();
        }

        return list;
    }
}