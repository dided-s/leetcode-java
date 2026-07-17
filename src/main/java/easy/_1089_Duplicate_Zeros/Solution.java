package easy._1089_Duplicate_Zeros;

import annotations.Easy;
import annotations.Explore;

@Easy
@Explore("Arrays 101")
public class Solution {

    public void duplicateZeros(int[] arr) {
        int lastIndex = arr.length - 1;
        int zeroes = 0;

        int index = 0;

        while (index <= lastIndex - zeroes) {
            if (arr[index] == 0) {
                if (index == lastIndex - zeroes) {
                    arr[lastIndex] = 0;
                    lastIndex--;
                    break;
                }
                zeroes++;
            }
            index++;
        }

        index = lastIndex - zeroes;

        while (zeroes > 0) {
            if (arr[index] == 0) {
                arr[index + zeroes] = 0;
                zeroes--;
                arr[index + zeroes] = 0;
            } else {
                arr[index + zeroes] = arr[index];
            }

            index--;
        }
    }
}