package easy._0009_Palindrome_Number;

import annotations.Easy;

@Easy
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int place = highPlaceNumber(x);

        while (x > 0) {
            if ((x % 10) != (x / place)) return false;
            x = (x % place) / 10;
            place /= 100;
        }

        return true;
    }

    private int highPlaceNumber(int num) {
        if (num < 0) num = -1 * num;

        int place = 1;
        if (num < 10) return 1;

        while (num >= 10) {
            num /= 10;
            place *= 10;
        }

        return place;
    }
}