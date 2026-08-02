package medium._0912_Sort_an_Array;

import annotations.Medium;
import annotations.Topic;

@Medium
@Topic("Sorting")
public class Solution {

    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    public int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);

        return temp;
    }

    public void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) return;

        int middle = left + (right - left) / 2;

        mergeSort(nums, temp, left, middle);
        mergeSort(nums, temp, middle + 1, right);

        merge(nums, temp, left, middle, right);
    }

    public void merge(int[] nums, int[] temp, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int sortedIndex = left;

        while (i <= middle && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[sortedIndex] = nums[i];
                sortedIndex++;
                i++;
            } else {
                temp[sortedIndex] = nums[j];
                sortedIndex++;
                j++;
            }
        }

        while (i <= middle) {
            temp[sortedIndex] = nums[i];
            sortedIndex++;
            i++;
        }

        while (j <= right) {
            temp[sortedIndex] = nums[j];
            sortedIndex++;
            j++;
        }

        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }
}