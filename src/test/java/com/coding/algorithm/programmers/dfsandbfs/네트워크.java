package com.coding.algorithm.programmers.dfsandbfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 네트워크 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(2, solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(1, solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    int count = 0;
    boolean[] check = new boolean[200];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(!check[i]) {
                check[i] = true;
                count = i;
                DFS(computers);
                answer++;
            }
        }
        return answer;
    }

    public void DFS(int[][] computers) {
        int temp = count;
        for (int i = 0; i < computers[temp].length; i++) {
            if (i != count && !check[i] && computers[temp][i] == 1) {
                check[i] = true;
                count = i;
                DFS(computers);
                count = temp;
            }
        }
    }

}
