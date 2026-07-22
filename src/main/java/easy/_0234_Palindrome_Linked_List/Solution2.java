package easy._0234_Palindrome_Linked_List;

import annotations.Easy;
import annotations.Explore;
import utils.LinkedListUtils;
import utils.ListNode;

@Easy
@Explore("Linked List")
public class Solution2 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        ListNode oneStep = head;
        ListNode twoSteps = head;

        while (twoSteps != null && twoSteps.next != null) {
            oneStep = oneStep.next;
            twoSteps = twoSteps.next.next;
        }

        ListNode start = head;
        ListNode end = reverseList(oneStep);

        System.out.println(LinkedListUtils.toList(start));
        System.out.println(LinkedListUtils.toList(end));

        while (start != null && end != null) {
            if (start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode prev = head;
        ListNode next = head.next;

        while (next != null) {
            ListNode newNext = next.next;
            next.next = prev;

            if (newNext == null) break;

            prev = next;
            next = newNext;
        }

        head.next = null;

        return next;
    }
}