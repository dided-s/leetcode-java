package hard._1510_Stone_Game_IV;

import annotations.Hard;

@Hard
public class Solution {

    public boolean winnerSquareGame(int n) {
        boolean[] winner = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!winner[i - j * j]) {
                    winner[i] = true;
                    break;
                }
            }
        }

        return winner[n];
    }
}