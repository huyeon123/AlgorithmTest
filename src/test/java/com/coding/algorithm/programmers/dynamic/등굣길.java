package com.coding.algorithm.programmers.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 등굣길 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(4, solution(4, 3, new int[][]{{2, 2}}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] routes = new int[n + 1][m + 1];
        boolean[][] check = new boolean[n + 1][m + 1];
        routes[1][1] = 1;
        for (int[] puddle : puddles) {
            check[puddle[1]][puddle[0]] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(check[i][j]) continue;
                if(i == 1){
                    if(j != 1) routes[i][j] = routes[i][j-1];
                } else {
                    if(j == 1) routes[i][j] = routes[i - 1][j];
                    else routes[i][j] = (routes[i][j-1] + routes[i-1][j]) % 1_000_000_007;
                }
            }
        }
        return routes[n][m] % 1_000_000_007;
    }
}
