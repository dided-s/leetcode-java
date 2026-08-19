package medium._1386_Cinema_Seat_Allocation;

import annotations.Medium;

import java.util.HashMap;
import java.util.Map;

@Medium
class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int numberInGroup = 4;
        int[] seatStarts = new int[]{2, 4, 6};

        Map<Integer, Boolean[]> canSeats = new HashMap<>();

        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0] - 1;
            int col = reservedSeat[1];

            for (int i = 0; i < seatStarts.length; i++) {
                if (seatStarts[i] <= col && col < seatStarts[i] + numberInGroup) {
                    if (!canSeats.containsKey(row)) {
                        canSeats.put(row, new Boolean[]{true, true, true});
                    }
                    canSeats.get(row)[i] = false;
                }
            }
        }

        int falseSum = (n - canSeats.size()) * 2;
        for (Boolean[] canSeat : canSeats.values()) {
            if (canSeat[0] && canSeat[2]) {
                falseSum += 2;
            } else if (canSeat[0] || canSeat[1] || canSeat[2]) {
                falseSum++;
            }
        }

        return falseSum;
    }
}