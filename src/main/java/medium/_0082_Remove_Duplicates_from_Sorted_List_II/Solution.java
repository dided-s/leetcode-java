package medium._0082_Remove_Duplicates_from_Sorted_List_II;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        ListNode newCurrent = newHead;

        ListNode prev = new ListNode(head.val - 1);
        ListNode current = head;

        while (current != null) {
            if (prev.val != current.val && (current.next == null || current.val != current.next.val)) {
                newCurrent.next = current;
                newCurrent = newCurrent.next;
            }

            prev = current;
            current = current.next;
        }

        newCurrent.next = null;

        return newHead.next;
    }
}