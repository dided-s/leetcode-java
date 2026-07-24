package easy._0013_Roman_to_Integer;

import annotations.Easy;

@Easy
public class Solution {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = fromRomanToInt(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            ans += fromRomanToInt(s.charAt(i));

            if (s.charAt(i - 1) == 'I' && (s.charAt(i) == 'V' || s.charAt(i) == 'X')) {
                ans -= 2;
            }
            if (s.charAt(i - 1) == 'X' && (s.charAt(i) == 'L' || s.charAt(i) == 'C')) {
                ans -= 20;
            }
            if (s.charAt(i - 1) == 'C' && (s.charAt(i) == 'D' || s.charAt(i) == 'M')) {
                ans -= 200;
            }
        }

        return ans;
    }

    private int fromRomanToInt(char roman) {
        if (roman == 'I') return 1;
        else if (roman == 'V') return 5;
        else if (roman == 'X') return 10;
        else if (roman == 'L') return 50;
        else if (roman == 'C') return 100;
        else if (roman == 'D') return 500;
        else if (roman == 'M') return 1000;

        return 0;
    }
}