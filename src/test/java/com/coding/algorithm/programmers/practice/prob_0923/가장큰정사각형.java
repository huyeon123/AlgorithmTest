package com.coding.algorithm.programmers.practice.prob_0923;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 가장큰정사각형 {
    int[][] gBoard;


    @Test
    void run() {
        assertEquals(9, solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
//        assertEquals(4, solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

    public int solution(int[][] board) {
        init(board);

        int side = check();

        return side * side;
    }

    private void init(int[][] board) {
        gBoard = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                gBoard[i + 1][j + 1] = board[i][j];
            }
        }
    }

    private int check() {
        int max = 0;

        for (int i = 1; i < gBoard.length; i++) {
            for (int j = 1; j < gBoard[i].length; j++) {
                if (gBoard[i][j] == 1) {
                    int left = gBoard[i - 1][j];
                    int up = gBoard[i][j - 1];
                    int leftUp = gBoard[i - 1][j - 1];
                    int min = Math.min(left, Math.min(up, leftUp));
                    gBoard[i][j] = min + 1;
                    max = Math.max(max, gBoard[i][j]);
                }
            }
        }

        return max;
    }

}
