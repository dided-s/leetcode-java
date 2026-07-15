package easy._0383_Ransom_Note;

import annotations.Easy;

import java.util.HashMap;
import java.util.Map;

@Easy
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> dict = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (dict.containsKey(c) && dict.get(c) > 0) {
                dict.put(c, dict.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}