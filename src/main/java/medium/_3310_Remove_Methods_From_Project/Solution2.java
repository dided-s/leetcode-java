package medium._3310_Remove_Methods_From_Project;

import annotations.Medium;

import java.util.*;

@Medium
public class Solution2 {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // 1. Create Map of our directions
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int to;
        int from;
        for (int[] invocation : invocations) {
            to = invocation[0];
            from = invocation[1];

            if (!map.containsKey(to)) {
                map.put(to, new HashSet<>());
            }
            map.get(to).add(from);
        }

        // 2. Create suspicious array, where true means that our index is suspicious
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;

        // 3. Go through all the suspicious ones and their children and mark them
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);

        while (!queue.isEmpty()) {
            int suspiciousIndex = queue.poll();

            if (!map.containsKey(suspiciousIndex)) continue;
            for (int toIndex : map.get(suspiciousIndex)) {
                if (!suspicious[toIndex]) {
                    suspicious[toIndex] = true;
                    queue.offer(toIndex);
                }
            }
        }

        // 4. if one of NON-suspicious call suspicious we need to save suspicious methods
        for (int[] invocation : invocations) {
            to = invocation[0];
            from = invocation[1];

            if (!suspicious[to] && suspicious[from]) {
                List<Integer> allMethods = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    allMethods.add(i);
                }

                return allMethods;
            }
        }

        // 5. Create list of non-suspicious methods
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                result.add(i);
            }
        }

        return result;
    }
}