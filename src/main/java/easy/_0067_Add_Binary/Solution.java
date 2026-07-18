package easy._0067_Add_Binary;

import annotations.Easy;
import annotations.Explore;

@Easy
@Explore("Array and String")
public class Solution {

    public String addBinary(String a, String b) {
        int radix = 2;
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int next = 0;

        while (i >= 0 || j >= 0) {
            int sum = next;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum % radix);
            next = sum / radix;
        }

        if (next != 0) result.append(next);

        return result.reverse().toString();
    }
}