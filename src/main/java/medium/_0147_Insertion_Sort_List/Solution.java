package medium._0147_Insertion_Sort_List;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head.next;
        ListNode next;

        ListNode sortedHead = head;
        sortedHead.next = null;

        while (current != null) {
            next = current.next;
            current.next = null;
            sortedHead = insertIntoSortedList(sortedHead, current);
            current = next;
        }

        return sortedHead;
    }

    public ListNode insertIntoSortedList(ListNode head, ListNode newNode) {
        if (newNode == null) return head;
        newNode.next = null;
        if (head == null) return newNode;
        if (newNode.val <= head.val) {
            newNode.next = head;
            return newNode;
        }

        ListNode current = head;

        while (current.next != null) {
            if (newNode.val <= current.next.val) {
                newNode.next = current.next;
                current.next = newNode;
                return head;
            }

            current = current.next;
        }
        current.next = newNode;

        return head;
    }
}