package easy._3507_Minimum_Pair_Removal_to_Sort_Array_I;

import annotations.Easy;
import annotations.Problem;

@Easy
@Problem("Linked List")
public class Solution {

    public int minimumPairRemoval(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        ListNode head = fromIntArrayToListNode(nums);

        int count = 0;

        while (!isSortedLinkedList(head)) {
            performOperation(head);
            count++;
        }

        return count;
    }

    private boolean isSortedLinkedList(ListNode head) {
        if (head == null || head.next == null) return true;

        while (head.next != null) {
            if (head.val > head.next.val) return false;
            head = head.next;
        }

        return true;
    }

    private ListNode fromIntArrayToListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return head;
    }

    private void performOperation(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode current = head;

        int minSum = current.val + current.next.val;
        ListNode minSumNode = current;
        current = current.next;

        while (current.next != null) {
            if (current.val + current.next.val < minSum) {
                minSum = current.val + current.next.val;
                minSumNode = current;
            }
            current = current.next;
        }

        minSumNode.val = minSumNode.val + minSumNode.next.val;
        minSumNode.next = minSumNode.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}