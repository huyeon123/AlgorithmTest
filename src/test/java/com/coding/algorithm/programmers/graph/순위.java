package com.coding.algorithm.programmers.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 순위 {
    int[][] check;
    int n, answer = 0;

    @Test
    void run() {
        assertEquals(2, solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results) {
        init(n, results);

        traversal();

        checkRow();

        return answer;
    }

    private void init(int n, int[][] results) {
        this.n = n;
        check = new int[n][n];

        for (int[] result : results) {
            int winner = result[0] - 1;
            int loser = result[1] - 1;
            check[winner][loser] = 1;
            check[loser][winner] = -1;
        }
    }

    private void traversal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (check[i][k] == 1 && check[k][j] == 1) {
                        check[i][j] = 1;
                        check[j][i] = -1;
                    }

                    if (check[i][k] == -1 && check[k][j] == -1) {
                        check[i][j] = -1;
                        check[j][i] = 1;
                    }
                }
            }
        }
    }

    private void checkRow() {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (check[i][j] == 0) count++;
                if (count > 1) break;
            }
            if (count == 1) answer++;
        }
    }

}
