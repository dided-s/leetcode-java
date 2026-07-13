package easy._0933_Number_of_Recent_Calls;

import annotations.Easy;
import annotations.LeetCode75;

import java.util.ArrayDeque;
import java.util.Queue;

@Easy
@LeetCode75("Queue")
public class RecentCounter {

    private final int pastMilliseconds;
    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
        this.pastMilliseconds = 3000;
    }

    public int ping(int t) {
        queue.offer(t);

        while (!queue.isEmpty() && queue.peek() < t - pastMilliseconds) {
            queue.poll();
        }

        return queue.size();
    }
}