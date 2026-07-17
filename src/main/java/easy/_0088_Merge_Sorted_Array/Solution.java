package easy._0088_Merge_Sorted_Array;

import annotations.Easy;
import annotations.Explore;

@Easy
@Explore("Arrays 101")
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        m--;
        n--;

        while (index >= 0) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[index] = nums1[m];
                    m--;
                } else {
                    nums1[index] = nums2[n];
                    n--;
                }
            } else if (m >= 0) {
                nums1[index] = nums1[m];
                m--;
            } else if (n >= 0) {
                nums1[index] = nums2[n];
                n--;
            }

            index--;
        }
    }
}