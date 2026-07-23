package medium._0024_Swap_Nodes_in_Pairs;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode newHead = prev;

        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode next = current.next.next;

            prev.next = current.next;
            current.next.next = current;
            current.next = next;

            prev = current;
            current = next;
        }

        return newHead.next;
    }
}