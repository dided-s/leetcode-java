package hard._0115_Distinct_Subsequences;

import annotations.Hard;
import annotations.Topic;

@Hard
@Topic("Dynamic Programming")
public class Solution {

    public int numDistinct(String s, String target) {
        if (s.length() < target.length()) {
            return 0;
        }

        Integer[][] cache = new Integer[s.length() + 1][target.length() + 1];

        return numDistinct(s, target, 0, 0, cache);
    }

    public int numDistinct(String s, String target, int i, int j, Integer[][] cache) {
        // target length is done - we have one answer
        if (j == target.length()) return 1;
        // s length is done - we don't have answer
        if (i == s.length()) return 0;

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (s.charAt(i) == target.charAt(j)) {
            return cache[i][j] = numDistinct(s, target, i + 1, j + 1, cache) + numDistinct(s, target, i + 1, j, cache);
        } else {
            return cache[i][j] = numDistinct(s, target, i + 1, j, cache);
        }
    }
}