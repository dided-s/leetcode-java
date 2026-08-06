package easy._0021_Merge_Two_Sorted_Lists;

import annotations.Easy;
import annotations.Explore;
import utils.ListNode;

@Easy
@Explore("Linked List")
public class Solution2 {

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode head = new ListNode(-1);
        ListNode current = head;


        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }

        if (head2 != null) {
            current.next = head2;
        }

        return head.next;
    }
}