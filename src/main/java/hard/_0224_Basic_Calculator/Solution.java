package hard._0224_Basic_Calculator;

import annotations.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

@Hard
public class Solution {

    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;

                result *= stack.pop();
                result += stack.pop();

                sign = 1;
            }
        }

        return result + sign * number;
    }
}