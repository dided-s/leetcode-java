package medium._1657_Determine_if_Two_Strings_Are_Close;

import annotations.LeetCode75;
import annotations.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Medium
@LeetCode75("Hash Map / Set")
public class Solution2 {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c : word1.toCharArray()) {
            if (!map1.containsKey(c)) map1.put(c, 0);
            map1.put(c, map1.get(c) + 1);
        }

        for (Character c : word2.toCharArray()) {
            if (!map2.containsKey(c)) map2.put(c, 0);
            map2.put(c, map2.get(c) + 1);
        }

        int[] values1 = map1.values().stream().mapToInt(v -> v).toArray();
        int[] values2 = map2.values().stream().mapToInt(v -> v).toArray();

        Arrays.sort(values1);
        Arrays.sort(values2);

        return Objects.equals(map1.keySet(), map2.keySet()) && Arrays.equals(values1, values2);
    }

}