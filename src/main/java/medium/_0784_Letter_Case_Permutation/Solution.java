package medium._0784_Letter_Case_Permutation;

import annotations.Medium;

import java.util.ArrayList;
import java.util.List;

@Medium
public class Solution {

    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        char[] chars = s.toCharArray();

        permute(0, chars, answer);

        return answer;
    }

    private void permute(int pos, char[] chars, List<String> answer) {
        int n = chars.length;
        if (pos == n) {
            answer.add(new String(chars));
            return;
        }
        if (Character.isLetter(chars[pos])) {
            chars[pos] = Character.toUpperCase(chars[pos]);
            permute(pos + 1, chars, answer);
            chars[pos] = Character.toLowerCase(chars[pos]);
            permute(pos + 1, chars, answer);
        } else {
            permute(pos + 1, chars, answer);
        }
    }
}