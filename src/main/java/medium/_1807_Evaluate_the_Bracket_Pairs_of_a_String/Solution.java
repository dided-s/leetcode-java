package medium._1807_Evaluate_the_Bracket_Pairs_of_a_String;

import annotations.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Medium
public class Solution {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder answer = new StringBuilder();

        int index = 0;

        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                int endBracketIndex = s.indexOf(')', index);
                String insideBracket = s.substring(index + 1, endBracketIndex);

                answer.append(map.getOrDefault(insideBracket, "?"));

                index = endBracketIndex;
            } else {
                answer.append(s.charAt(index));
            }

            index++;
        }

        return answer.toString();
    }
}