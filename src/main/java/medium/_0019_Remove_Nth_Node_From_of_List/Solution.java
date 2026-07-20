package medium._0019_Remove_Nth_Node_From_of_List;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode left = new ListNode(0);
        left.next = head;
        int i = 0;
        ListNode right = head;

        while (i < n && right != null) {
            right = right.next;
            i++;
        }

        if (right == null) return head.next;

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        System.out.println(i);

        left.next = left.next.next;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}