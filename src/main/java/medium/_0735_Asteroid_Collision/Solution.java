package medium._0735_Asteroid_Collision;

import annotations.LeetCode75;
import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
@LeetCode75("Stack")
public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            collide(stack, asteroid);
        }

        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (index >= 0) {
            result[index--] = stack.pop();
        }
        return result;
    }

    private void collide(Deque<Integer> stack, int asteroid) {
        while (!stack.isEmpty()) {
            if ((stack.peek() > 0 && asteroid > 0) || (stack.peek() < 0 && asteroid < 0)) {
                break;
            }

            if (stack.peek() < 0) {
                break;
            }

            int sum = asteroid + stack.peek();

            if (sum == 0) {
                stack.pop();
                return;
            }

            if (sum > 0) {
                return;
            }

            if (sum < 0) {
                stack.pop();
            }
        }

        stack.push(asteroid);
    }
}