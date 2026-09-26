package hard._1096_Brace_Expansion_II;

import annotations.Hard;

import java.util.*;

@Hard
public class Solution3 {

    public List<String> braceExpansionII(String expression) {
        expression = expression.replaceAll("([a-z])", "{$1}");
        expression = expression.replaceAll("(}\\{)", "}.{");
        System.out.println(expression);

        Deque<StringBuilder> insideBrackets = new ArrayDeque<>();
        insideBrackets.push(new StringBuilder());


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            switch (c) {
                case '{' -> insideBrackets.push(new StringBuilder());
                case '}' -> {
                    var end = insideBrackets.pop();
                    String modifyAnswer = helper(end.toString());
                    System.out.println("helper answer: " + modifyAnswer);

                    end = insideBrackets.pop().append(modifyAnswer);
                    modifyAnswer = helper(end.toString());
                    insideBrackets.push(new StringBuilder(modifyAnswer));
                    System.out.println("helper answer: " + modifyAnswer);
                }
                default -> insideBrackets.peek().append(c);
            }
        }

        System.out.println(insideBrackets);
        insideBrackets.forEach(System.out::println);

        var end = insideBrackets.pop();
        String modifyAnswer = helper(end.toString());

        return List.of(modifyAnswer.split(","));
    }

    public String helper(String expression) {
        System.out.println("helper: " + expression);

        if (!expression.contains(".")) {
            Set<String> answer = new TreeSet<>(List.of(expression.split(",")));
            return String.join(",", answer);
        }
        String first = expression.substring(0, expression.indexOf("."));
        String second = expression.substring(expression.indexOf(".") + 1);

        String[] array1 = first.split(",");
        String[] array2 = second.split(",");

        Set<String> answer = new TreeSet<>();

        for (String a1 : array1) {
            for (String a2 : array2) {
                answer.add(a1 + a2);
            }
        }

        return String.join(",", answer);
    }
}