package medium._0678_Valid_Parenthesis_String;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
public class Solution2 {

    public boolean checkValidString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                int starCount = 0;
                while (!stack.isEmpty() && stack.peek() == '*') {
                    stack.pop();
                    starCount++;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    if (starCount > 0) {
                        starCount--;
                    } else {
                        return false;
                    }
                }
                for (int i = 0; i < starCount; i++) {
                    stack.push('*');
                }
            } else {
                stack.push(c);
            }
        }

        int leftCount = 0;
        int starCount = 0;

        while (!stack.isEmpty()) {
            //System.out.println(stack.peek());
            if (stack.peek() == '*') {
                starCount++;
            } else {
                leftCount++;
            }
            if (leftCount > starCount) {
                return false;
            }
            stack.pop();
        }

        return true;
    }
}