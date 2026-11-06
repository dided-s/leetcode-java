package medium._2747_Count_Zero_Request_Servers;

import annotations.Medium;

import java.util.Arrays;

@Medium
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Сортируем индексы запросов, чтобы сохранить исходный порядок ответов.
        Integer[] queryOrder = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryOrder[i] = i;
        }

        Arrays.sort(queryOrder,
                (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] answer = new int[queries.length];

        // Количество логов каждого сервера внутри текущего окна.
        int[] frequency = new int[n + 1];

        int activeServers = 0;
        int left = 0;
        int right = 0;

        for (int queryIndex : queryOrder) {
            int end = queries[queryIndex];
            int start = end - x;

            // Добавляем логи до правой границы включительно.
            while (right < logs.length && logs[right][1] <= end) {
                int serverId = logs[right][0];

                if (frequency[serverId] == 0) {
                    activeServers++;
                }

                frequency[serverId]++;
                right++;
            }

            // Удаляем логи, которые находятся левее окна.
            while (left < right && logs[left][1] < start) {
                int serverId = logs[left][0];

                frequency[serverId]--;

                if (frequency[serverId] == 0) {
                    activeServers--;
                }

                left++;
            }

            answer[queryIndex] = n - activeServers;
        }

        return answer;
    }
}