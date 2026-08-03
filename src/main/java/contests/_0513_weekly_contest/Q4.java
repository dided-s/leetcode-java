package contests._0513_weekly_contest;

import annotations.Hard;

@Hard
public class Q4 {

    // Q4. Count Subarrays With Even Odd Ratio I
    public long countRatioSubarrays(int[] nums, int a, int b) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] % 2 == 1 ? 1 : 0;

        // prefix sum: x * b - y * a <= 0.
        // [i, j] is good if prefix[j] - prefix[i] <= 0

        long[] prefix = new long[nums.length];
        prefix[0] = nums[0] % 2 == 0 ? b : -a;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + (nums[i] % 2 == 0 ? b : -a);
        }

        long[] temp = new long[prefix.length];

        return mergeSort(prefix, temp, 0, prefix.length - 1);
    }

    // use merge sort to count how many indexes is less than current wuth O(nlog(n))
    public long mergeSort(long[] array, long[] temp, int left, int right) {
        if (left == right) return array[left] <= 0 ? 1 : 0;

        int middle = (left + right) / 2;

        long count = 0;

        count += mergeSort(array, temp, left, middle);
        count += mergeSort(array, temp, middle + 1, right);

        count += merge(array, temp, left, middle, right);

        return count;
    }

    public long merge(long[] array, long[] temp, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;

        int sortedIndex = left;

        long count = 0;

        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                temp[sortedIndex++] = array[i++];
            } else {
                // We want to count prefix[i] >= prefix[j].
                // If we want to intercept prefix[j] in merge sort array
                // we know that (middle - i + 1) is less than current index
                count += middle - i + 1;
                temp[sortedIndex++] = array[j++];
            }
        }

        while (i <= middle) {
            temp[sortedIndex++] = array[i++];
        }

        while (j <= right) {
            temp[sortedIndex++] = array[j++];
        }

        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }

        return count;
    }
}
