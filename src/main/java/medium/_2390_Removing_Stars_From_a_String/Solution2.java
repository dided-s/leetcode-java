package medium._2390_Removing_Stars_From_a_String;

import annotations.LeetCode75;
import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
@LeetCode75("Stack")
public class Solution2 {

    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}