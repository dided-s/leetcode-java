package medium._0002_Add_Two_Numbers;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            int digit = l1.val + l2.val + next;
            next = digit / 10;
            current.next = new ListNode(digit % 10);

            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null && next != 0) {
            int digit = l1.val + next;
            next = digit / 10;
            current.next = new ListNode(digit % 10);

            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null && next != 0) {
            int digit = l2.val + next;
            next = digit / 10;
            current.next = new ListNode(digit % 10);

            current = current.next;
            l2 = l2.next;
        }

        if (next != 0) {
            current.next = new ListNode(next);
        } else {
            current.next = (l1 != null) ? l1 : l2;
        }

        return head.next;
    }
}