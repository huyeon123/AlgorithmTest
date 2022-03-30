package com.coding.algorithm.programmers.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 양궁대회 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
//        Assertions.assertArrayEquals(new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0},
//                solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));
        Assertions.assertArrayEquals(new int[]{-1}, solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    int[] answer = {-1};
    int[] temp = new int[11];
    int max = Integer.MIN_VALUE;

    public void dfs(int n, int[] info, int shoot) {
        if (shoot == n) {
            int apeach = 0;
            int lion = 0;
            for (int i = 0; i <= 10; i++) {
                if (info[i] != 0 || temp[i] != 0) {
                    if (info[i] < temp[i])
                        lion += 10 - i;
                    else
                        apeach += 10 - i;
                }
            }
            if (lion > apeach) {
                if (lion - apeach >= max) {
                    answer = temp.clone();
                    max = lion - apeach;
                }
            }
            return;
        }

        for (int j = 0; j <= 10 && temp[j] <= info[j]; j++) {
            temp[j]++;
            dfs(n, info, shoot + 1);
            temp[j]--;
        }
    }

    public int[] solution(int n, int[] info) {
        dfs(n, info, 0);
        return answer;
    }

}
