package easy._0345_Reverse_Vowels_of_a_String;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Array / String")
public class Solution {
    public String reverseVowels(String s) {
        char [] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            if (!isVowel(s.charAt(leftIndex))) {
                leftIndex++;
                continue;
            }

            if (!isVowel(s.charAt(rightIndex))) {
                rightIndex--;
                continue;
            }

            char temp = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }

        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' ||
                c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I';
    }
}