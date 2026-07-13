package medium._0394_Decode_String;

import annotations.LeetCode75;
import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
@LeetCode75("Stack")
public class Solution {

    public String decodeString(String s) {
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        stringStack.push(new StringBuilder());

        int currentNum = 0;

        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(currentNum);
                currentNum = 0;
                stringStack.push(new StringBuilder());
            } else if (c == ']') {
                int num = numStack.pop();
                StringBuilder lastString = stringStack.pop();
                lastString.repeat(lastString.toString(), num - 1);
                if (stringStack.isEmpty()) {
                    stringStack.push(lastString);
                } else {
                    stringStack.peek().append(lastString);
                }
            } else {
                stringStack.peek().append(c);
            }

            i++;
        }

        return stringStack.pop().toString();
    }
}