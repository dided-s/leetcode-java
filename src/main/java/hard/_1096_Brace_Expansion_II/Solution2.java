package hard._1096_Brace_Expansion_II;

import annotations.Hard;

import java.util.*;

@Hard
public class Solution2 {

    public List<String> braceExpansionII(String expression) {
        expression = expression.replaceAll("([a-z])", "{$1}");
        expression = expression.replaceAll("(}\\{)", "}.{");
        System.out.println(expression);
        Deque<StringBuilder> insideBrackets = new ArrayDeque<>();
        Deque<String> signs = new ArrayDeque<>();
        insideBrackets.push(new StringBuilder());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            switch (c) {
                case '{' -> insideBrackets.push(new StringBuilder());
                case '}' -> {
                    if (!signs.isEmpty()) {
                        String sign = signs.pop();
                        String expression2 = insideBrackets.pop().toString();
                        String expression1 = insideBrackets.pop().toString();

                        String answer = helper(expression1, sign, expression2);

                        insideBrackets.push(new StringBuilder(answer));
                    } else {
                        StringBuilder end = insideBrackets.pop();
                        insideBrackets.peek().append(end);
                    }
                }
                case '.' -> signs.push(".");
                case ',' -> signs.push(",");
                default -> insideBrackets.peek().append(c);
            }
        }

        insideBrackets.forEach(System.out::println);

        System.out.println(insideBrackets);
        System.out.println(signs);

        return null;
    }

    public String helper(String expression1, String sign, String expression2) {
        if (sign.equals(",")) {
            return expression1 + "," + expression2;
        }
        String[] array1 = expression1.split(",");
        String[] array2 = expression2.split(",");

        Set<String> answer = new TreeSet<>();
        for (String s1: array1) {
            for (String s2: array2) {
                answer.add(s1 + s2);
            }
        }

        return String.join(",", answer);
    }
}