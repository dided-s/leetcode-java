package medium._0143_Reorder_List;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 1. Find first and second parts and split
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondPart = slow.next;
        slow.next = null;

        // 2. Reverse second part
        ListNode current = head;
        ListNode reverseCurrent = reverse(secondPart);

        // 3. Merge two lists
        mergeTwoLists(current, reverseCurrent);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;

            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return head.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

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