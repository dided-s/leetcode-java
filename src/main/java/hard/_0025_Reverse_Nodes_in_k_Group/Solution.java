package hard._0025_Reverse_Nodes_in_k_Group;

import annotations.Explore;
import annotations.Hard;
import utils.ListNode;

@Hard
@Explore("Linked List")
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1) return head;

        // 1. Create left and right pointers:
        // [(1 2 3) 4 5] k=3
        // left.next -> 1
        // right -> 3
        ListNode left = new ListNode(-1);
        left.next = head;
        ListNode right = head;

        int groupNumber = 1;

        while (true) {
            // 2. Count and find right pointer
            int count = 1;
            while (count < k) {
                if (right == null) return head;
                right = right.next;
                count++;
            }

            // right=null means not full group and we can stop
            if (right == null) break;

            // 3. Save old next - it is start of new group
            ListNode next = right.next;

            // 4. Reverse part of linked list
            right.next = null;
            ListNode reverseNode = reverseList(left.next);

            // 4.5 We have to save new head after first reverse
            if (groupNumber++ == 1) head = reverseNode;

            // 5. Match new left and right links
            ListNode newLeft = left.next;
            left.next = right;
            newLeft.next = next;

            // 6. Prepare to new iteration
            right = next;
            left = newLeft;
        }

        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;

            if (next == null) break;

            prev = current;
            current = next;
        }

        head.next = null;

        return current;
    }
}