package contests._0513_weekly_contest;

import annotations.Medium;

@Medium
public class Q3 {

    // Q3. Count of Unfinished Tasks After Each Shift
    public int[] countTasks(int[] tasks, int[] shifts) {
        if (tasks == null || tasks.length == 0) return new int[0];

        int[] answer = new int[shifts.length];

        // 1. Create Prefix sum array. We need to do it long
        long[] prefixTaskSum = prefixSum(tasks);

        int lastTaskIndex = 0;
        long lastTaskTime = 0;
        long shiftTime;

        // 2. diff for not completed task. We need to add previous prefixSum time
        long diff;

        for (int shiftIndex = 0; shiftIndex < shifts.length; shiftIndex++) {
            shiftTime = shifts[shiftIndex];
            diff = 0;

            if (lastTaskTime != 0) {
                // 3. If current task has time more than shift, we can "continue"
                if (shiftTime < lastTaskTime) {
                    lastTaskTime -= shiftTime;
                    answer[shiftIndex] = tasks.length - lastTaskIndex;
                    continue;
                }

                // 4. We go to next task after not completed
                shiftTime -= lastTaskTime;
                diff = prefixTaskSum[lastTaskIndex];
            }

            // 5. Find upper bound index
            lastTaskIndex = upperBound(prefixTaskSum, shiftTime + diff);
            answer[shiftIndex] = tasks.length - lastTaskIndex;

            if (lastTaskIndex == tasks.length) {
                lastTaskTime = 0;
                lastTaskIndex = 0;
            } else {
                lastTaskTime = prefixTaskSum[lastTaskIndex] - (shiftTime + diff);
            }
        }

        return answer;
    }

    // We need to find right index after current value. Use binary search
    private static int upperBound(long[] array, long target) {
        int middle;
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle + 1;
            }
            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private static long[] prefixSum(int[] array) {
        if (array == null || array.length == 0) return new long[0];
        long[] prefixSum = new long[array.length];

        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }

        return prefixSum;
    }
}