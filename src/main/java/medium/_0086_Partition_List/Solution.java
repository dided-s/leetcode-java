package medium._0086_Partition_List;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode moreOrEqual = new ListNode(-1);

        ListNode lessHead = less;
        ListNode moreOrEqualHead = moreOrEqual;

        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                moreOrEqual.next = current;
                moreOrEqual = moreOrEqual.next;
            }

            current = current.next;
        }

        less.next = moreOrEqualHead.next;
        moreOrEqual.next = null;

        return lessHead.next;
    }
}