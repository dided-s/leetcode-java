package medium._0092_Reverse_Linked_List_II;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        if (left == right) return head;

        int count = 0;
        ListNode current = new ListNode(-1);
        current.next = head;
        head = current;

        while (count < left - 1) {
            current = current.next;
            count++;
        }
        ListNode beforeStart = current;

        while (count < right) {
            current = current.next;
            count++;
        }

        ListNode end = current;
        ListNode afterEnd = end.next;

        end.next = null;

        reverse(beforeStart.next);

        beforeStart.next.next = afterEnd;
        beforeStart.next = end;

        return head.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode current = head.next;
        ListNode next = head.next.next;

        while (current != null) {
            current.next = prev;
            if (next == null) break;

            prev = current;
            current = next;
            next = current.next;
        }
        head.next = null;

        return current;
    }
}