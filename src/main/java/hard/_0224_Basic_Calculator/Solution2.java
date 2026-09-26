package hard._0224_Basic_Calculator;

import annotations.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

@Hard
public class Solution2 {

    public int calculate(String expression) {
        expression = modifyString(expression);

        //System.out.println(expression);

        Deque<Character> signs = new ArrayDeque<>();
        Deque<Integer> numbers = new ArrayDeque<>();

        signs.push('(');

        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);

            switch (c) {
                case '+', '-' -> signs.push(c);
                case '(' -> signs.push(c);
                case ')' -> endBrace(signs, numbers);
                default -> {
                    char previousChar = expression.charAt(i - 1);

                    if (Character.isDigit(previousChar)) {
                        int number = numbers.pop();
                        number = number * 10 + (c - '0');
                        numbers.push(number);
                    } else {
                        numbers.push(c - '0');
                    }
                }
            }
        }

        //System.out.println(signs);
        //System.out.println(numbers);

        return numbers.pop();
    }

    public void endBrace(Deque<Character> signs, Deque<Integer> numbers) {
        Deque<Integer> currentNumbers = new ArrayDeque<>();
        Deque<Character> currentSigns = new ArrayDeque<>();

        while (!signs.isEmpty() && signs.peek() != '(') {
            var sign = signs.pop();
            var right = numbers.pop();

            currentSigns.push(sign);
            currentNumbers.push(right);
        }
        signs.pop();

        int sum = numbers.pop();
        while (!currentSigns.isEmpty()) {
            var sign = currentSigns.pop();
            var right = currentNumbers.pop();

            switch (sign) {
                case '+' -> sum += right;
                case '-' -> sum -= right;
            }
        }

        numbers.push(sum);
    }

    public String modifyString(String s) {
        StringBuilder answer = new StringBuilder();

        s = '(' + s + ')';
        answer.append('(');

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            char lastAnswerChar = answer.charAt(answer.length() - 1);
            if (lastAnswerChar == '(' && c == '-') {
                answer.append('0');
            }

            answer.append(c);
        }

        return answer.toString();
    }
}