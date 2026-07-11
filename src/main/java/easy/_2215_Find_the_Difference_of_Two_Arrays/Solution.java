package easy._2215_Find_the_Difference_of_Two_Arrays;

import annotations.Easy;
import annotations.LeetCode75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Easy
@LeetCode75("Hash Map / Set")
public class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> h1 = new HashSet<>();
        for (int num : nums1) h1.add(num);

        HashSet<Integer> h2 = new HashSet<>();
        for (int num : nums2) h2.add(num);

        List<Integer> l1 = new ArrayList<>(h1);
        List<Integer> l2 = new ArrayList<>(h2);

        l1.removeAll(h2);
        l2.removeAll(h1);

        List<List<Integer>> res = new ArrayList<>();
        res.add(l1);
        res.add(l2);

        return res;
    }
}