package easy._0234_Palindrome_Linked_List;

import annotations.Easy;
import annotations.Explore;
import utils.ListNode;

@Easy
@Explore("Linked List")
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        ListNode oneStep = head;
        ListNode twoSteps = head;

        ListNode prev = new ListNode(-1);
        ListNode next = head;

        // At the same time we walk fast and slow and reverse first part
        while (twoSteps != null && twoSteps.next != null) {
            twoSteps = twoSteps.next.next;
            oneStep = oneStep.next;


            ListNode newNext = next.next;
            next.next = prev;

            if (newNext == null) break;

            prev = next;
            next = newNext;
        }

        head.next = null;

        // if our list has odd number of elements we need to skip middle element
        // twoSteps == null - even number of elements
        if (twoSteps != null) oneStep = oneStep.next;
        ListNode firstPart = oneStep;
        ListNode secondPart = prev;

        while (secondPart != null && firstPart != null) {
            if (secondPart.val != firstPart.val) {
                return false;
            }
            firstPart = firstPart.next;
            secondPart = secondPart.next;
        }

        return true;
    }
}