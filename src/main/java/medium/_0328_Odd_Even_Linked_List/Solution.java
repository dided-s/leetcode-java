package medium._0328_Odd_Even_Linked_List;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode evenHead = head.next;
        ListNode odd = head;

        while (odd.next != null) {
            ListNode even = odd.next;
            odd.next = odd.next.next;

            if (odd.next == null) {
                break;
            }

            even.next = even.next.next;
            odd = odd.next;
        }

        odd.next = evenHead;

        return head;
    }
}