package medium._0024_Swap_Nodes_in_Pairs;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List | Recursion I")
public class Solution2 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        ListNode nextPairHead = head.next.next;

        head.next.next = head;
        head.next = swapPairs(nextPairHead);

        return newHead;
    }
}