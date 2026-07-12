package medium._0443_String_Compression;

import annotations.LeetCode75;
import annotations.Medium;

@Medium
@LeetCode75("Array / String")
public class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int result = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                count++;
            } else {
                chars[result] = chars[i - 1];
                result++;

                if (count > 1) {
                    for (var ch: String.valueOf(count).toCharArray()) {
                        chars[result] = ch;
                        result++;
                    }
                }
                count = 1;
            }
        }

        chars[result] = chars[chars.length - 1];
        result++;

        if (count > 1) {
            for (var ch: String.valueOf(count).toCharArray()) {
                chars[result] = ch;
                result++;
            }
        }

        return result;
    }
}