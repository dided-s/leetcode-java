package medium._0567_Permutation_in_String;

import annotations.Medium;
import annotations.Topic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Medium
@Topic("Sliding Window")
public class Solution2 {

    public boolean checkInclusion(String permutationString, String string) {
        if (permutationString.length() > string.length()) return false;

        // 1. create permutation string frequency map
        Map<Character, Integer> permutatuionMap = new HashMap<>();
        for (char c : permutationString.toCharArray()) {
            permutatuionMap.put(c, permutatuionMap.getOrDefault(c, 0) + 1);
        }
        Set<Character> permutations = permutatuionMap.keySet();

        // 2. create current window map
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char ch : permutations) {
            windowMap.put(ch, 0);
        }

        char ch;
        for (int i = 0; i < permutationString.length(); i++) {
            ch = string.charAt(i);

            if (permutations.contains(ch)) {
                windowMap.put(ch, windowMap.get(ch) + 1);
            }
        }
        if (windowMap.equals(permutatuionMap)) return true;

        for (int i = permutationString.length(); i < string.length(); ++i) {
            // 3. remove last ch from window
            ch = string.charAt(i - permutationString.length());

            if (permutations.contains(ch)) {
                windowMap.put(ch, windowMap.get(ch) - 1);
            }

            // 4. add current ch to window
            ch = string.charAt(i);

            if (permutations.contains(ch)) {
                windowMap.put(ch, windowMap.get(ch) + 1);
            }

            if (windowMap.equals(permutatuionMap)) return true;
        }

        return false;
    }
}