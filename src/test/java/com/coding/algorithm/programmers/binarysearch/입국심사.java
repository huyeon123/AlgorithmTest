package com.coding.algorithm.programmers.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class 입국심사 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(28, solution(6, new int[]{7, 10}));
        Assertions.assertEquals(35, solution(10, new int[]{7, 10, 12}));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = times[0];
        long right = (long) n * times[times.length - 1];
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int time : times) sum += mid / time;
            if (sum < n) left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

}
