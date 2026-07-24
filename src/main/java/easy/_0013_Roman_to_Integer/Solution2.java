package easy._0013_Roman_to_Integer;

import annotations.Easy;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

@Easy
public class Solution2 {

    private Map<Character, Integer> romanToInt = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        Queue<Character> chars = new ArrayDeque<>();
        Queue<Integer> counts = new ArrayDeque<>();

        System.out.println(s);

        char prev = s.charAt(0);
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                chars.add(prev);
                counts.add(count);

                count = 1;
                prev = c;
            }
        }
        chars.add(prev);
        counts.add(count);

        System.out.println(chars);
        System.out.println(counts);

        int answer = 0;
        int prevNum = 10000;
        while (!chars.isEmpty()) {
            char roman = chars.poll();
            count = counts.poll();
            int num = romanToInt.get(roman);

            if (num / prevNum == 5 || num / prevNum == 10) {
                answer = answer - 2 * prevNum + count * num;
            } else {
                answer = answer + count * num;
            }

            System.out.println(answer);

            prevNum = num;
        }

        return answer;
    }
}