package easy._2409_Count_Days_Spent_Together;

import annotations.Easy;

@Easy
public class Solution {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDays = toDayCount(arriveAlice);
        int leaveAliceDays = toDayCount(leaveAlice);
        int arriveBobDays = toDayCount(arriveBob);
        int leaveBobDays = toDayCount(leaveBob);

        int maxArriveDays = Math.max(arriveAliceDays, arriveBobDays);
        int minLeaveDays = Math.min(leaveAliceDays, leaveBobDays);

        return Math.max(0, minLeaveDays - maxArriveDays + 1);
    }

    private int toDayCount(String date) {
        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayCount = 0;
        for (int i = 1; i < month; i++) {
            dayCount += daysInMonth[i - 1];
        }

        return dayCount + day;
    }
}