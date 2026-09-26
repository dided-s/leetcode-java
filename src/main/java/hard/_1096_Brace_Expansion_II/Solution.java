package hard._1096_Brace_Expansion_II;

import annotations.Hard;

import java.util.*;

@Hard
public class Solution {

    public List<String> braceExpansionII(String expression) {
        expression = modifyExpression(expression);

        Deque<Set<String>> stack = new ArrayDeque<>();
        Deque<Character> signs = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            switch (c) {
                case '{', '.', ',' -> signs.push(c);
                case '}' -> endBrace(stack, signs);
                default -> stack.push(Set.of(String.valueOf(c)));

            }
        }

        return stack.pop().stream().toList();
    }

    public void endBrace(Deque<Set<String>> stack, Deque<Character> signs) {
        while (!signs.isEmpty() && signs.peek() != '{') {
            var sign = signs.pop();
            var right = stack.pop();
            var left = stack.pop();

            Set<String> answer = new TreeSet<>();

            if (sign.equals(',')) {
                answer.addAll(left);
                answer.addAll(right);
            } else if (sign.equals('.')) {
                for (String l : left) {
                    for (String r : right) {
                        answer.add(l + r);
                    }
                }
            }

            stack.push(answer);
        }

        signs.pop();
    }

    public String modifyExpression(String expression) {
        StringBuilder answer = new StringBuilder(expression);

        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i - 1) == '}' && answer.charAt(i) == '{') {
                int rightBraceIndex = rightBraceIndex(answer, i);
                int leftBraceIndex = leftBraceIndex(answer, i - 1);

                answer.insert(rightBraceIndex, '}');
                answer.insert(i, '.');
                answer.insert(leftBraceIndex, '{');
            } else if (answer.charAt(i - 1) == '}' && Character.isLetter(answer.charAt(i))) {
                int leftBraceIndex = leftBraceIndex(answer, i - 1);

                answer.insert(i + 1, '}');
                answer.insert(i, '.');
                answer.insert(leftBraceIndex, '{');
            } else if (Character.isLetter(answer.charAt(i - 1)) && answer.charAt(i) == '{') {
                int rightBraceIndex = rightBraceIndex(answer, i);

                answer.insert(rightBraceIndex, '}');
                answer.insert(i, '.');
                answer.insert(i - 1, '{');
            } else if (Character.isLetter(answer.charAt(i - 1)) && Character.isLetter(answer.charAt(i))) {
                answer.insert(i + 1, '}');
                answer.insert(i, '.');
                answer.insert(i - 1, '{');
            }
        }

        return answer.toString();
    }

    public int leftBraceIndex(CharSequence expression, int rightBraceIndex) {
        int balance = 1;

        int i = rightBraceIndex - 1;

        while (i >= 0 && balance > 0) {
            if (expression.charAt(i) == '{') {
                balance--;
            } else if (expression.charAt(i) == '}') {
                balance++;
            }
            i--;
        }

        return i + 1;
    }

    public int rightBraceIndex(CharSequence expression, int leftBraceIndex) {
        int balance = 1;

        int i = leftBraceIndex + 1;
        while (i < expression.length() && balance > 0) {
            if (expression.charAt(i) == '{') {
                balance++;
            } else if (expression.charAt(i) == '}') {
                balance--;
            }
            i++;
        }
        return i - 1;
    }
}