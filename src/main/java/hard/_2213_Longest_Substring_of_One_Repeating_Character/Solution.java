package hard._2213_Longest_Substring_of_One_Repeating_Character;

import annotations.Hard;

import java.util.Map;
import java.util.TreeMap;

@Hard
public class Solution {

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        TreeMap<Integer, Integer> segments = new TreeMap<>();
        TreeMap<Integer, Integer> lengths = new TreeMap<>();

        char[] string = s.toCharArray();

        int left = 0;
        int right = 1;

        while (right < s.length()) {
            if (string[right] != string[right - 1]) {
                segments.put(left, right - 1);
                lengths.put(right - left, lengths.getOrDefault(right - left, 0) + 1);
                left = right;
            }

            right++;
        }
        segments.put(left, right - 1);
        lengths.put(right - left, lengths.getOrDefault(right - left, 0) + 1);

        int[] result = new int[queryIndices.length];

        for (int queryIndex = 0; queryIndex < queryIndices.length; queryIndex++) {
            int position = queryIndices[queryIndex];
            char ch = queryCharacters.charAt(queryIndex);

            if (string[position] == ch) {
                result[queryIndex] = lengths.lastKey();
                continue;
            }

            int L = segments.floorKey(position);
            int R = segments.get(L);

            decrementCounter(lengths, R - L + 1);
            segments.remove(L);

            if (L <= position - 1) {
                segments.put(L, position - 1);
                incrementCounter(lengths, position - L);
            }

            if (position + 1 <= R) {
                segments.put(position + 1, R);
                incrementCounter(lengths, R - position);
            }

            int newL = position;
            int newR = position;

            Integer rightKey = segments.ceilingKey(position + 1);
            if (rightKey != null && rightKey == position + 1 && string[position + 1] == ch) {
                int rightR = segments.get(rightKey);

                decrementCounter(lengths, rightR - rightKey + 1);
                segments.remove(rightKey);
                newR = rightR;
            }

            Integer leftKey = segments.floorKey(position - 1);
            if (leftKey != null && segments.get(leftKey) == position - 1 && string[position - 1] == ch) {
                int leftR = segments.get(leftKey);

                decrementCounter(lengths, leftR - leftKey + 1);
                segments.remove(leftKey);
                newL = leftKey;
            }

            segments.put(newL, newR);
            incrementCounter(lengths, newR - newL + 1);

            string[position] = ch;
            result[queryIndex] = lengths.lastKey();
        }

        return result;
    }

    private <KEY> void decrementCounter(Map<KEY, Integer> counter, KEY key) {
        if (!counter.containsKey(key)) {
            return;
        }

        int count = counter.get(key);

        if (count == 1) {
            counter.remove(key);
        } else {
            counter.put(key, count - 1);
        }
    }

    private <KEY> void incrementCounter(Map<KEY, Integer> counter, KEY key) {
        counter.put(key, counter.getOrDefault(key, 0) + 1);
    }
}