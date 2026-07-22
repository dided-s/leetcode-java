package medium._0061_Rotate_List;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = 1;
        ListNode tail = head;

        // 1. Find tail and length
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        tail.next = head;

        // 2. Reduce k and find number of iterations
        k = k % length;
        k = length - k;

        System.out.println(k);

        // 3. Find new tail
        ListNode newTail = head;
        while (k > 1) {
            newTail = newTail.next;
            k--;
        }
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}