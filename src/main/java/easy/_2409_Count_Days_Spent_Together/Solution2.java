package easy._2409_Count_Days_Spent_Together;

import annotations.Easy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Easy
public class Solution2 {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate arriveAliceDate = LocalDate.parse("2015-" + arriveAlice);
        LocalDate leaveAliceDate = LocalDate.parse("2015-" + leaveAlice);
        LocalDate arriveBobDate = LocalDate.parse("2015-" + arriveBob);
        LocalDate leaveBobDate = LocalDate.parse("2015-" + leaveBob);

        LocalDate maxArriveDate = arriveAliceDate.isAfter(arriveBobDate) ? arriveAliceDate : arriveBobDate;
        LocalDate minLeaveDate = leaveAliceDate.isBefore(leaveBobDate) ? leaveAliceDate : leaveBobDate;

        int days = (int) ChronoUnit.DAYS.between(maxArriveDate, minLeaveDate) + 1;

        return Math.max(days, 0);
    }
}