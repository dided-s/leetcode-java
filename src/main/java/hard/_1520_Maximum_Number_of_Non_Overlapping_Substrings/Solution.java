package hard._1520_Maximum_Number_of_Non_Overlapping_Substrings;

import annotations.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Hard
public class Solution {

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] firstArray = new int[26];
        int[] lastArray = new int[26];

        Arrays.fill(firstArray, n);
        Arrays.fill(lastArray, -1);

        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'a';
            firstArray[charIndex] = Math.min(firstArray[charIndex], i);
            lastArray[charIndex] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {
            if (lastArray[c] == -1) continue;

            int l = firstArray[c];
            int r = lastArray[c];
            boolean valid = true;

            for (int i = l; i <= r; i++) {
                int x = s.charAt(i) - 'a';

                if (firstArray[x] < l) {
                    valid = false;
                    break;
                }

                r = Math.max(r, lastArray[x]);
            }

            if (valid) {
                intervals.add(new int[]{l, r});
            }
        }

        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();
        int end = -1;

        for (int[] interval : intervals) {
            if (interval[0] > end) {
                ans.add(s.substring(interval[0], interval[1] + 1));
                end = interval[1];
            }
        }

        return ans;
    }
}