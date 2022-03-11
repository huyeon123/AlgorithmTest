package com.coding.algorithm.programmers.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(2, solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
        Assertions.assertEquals(2, solution(new int[][]{{-30, 0}, {-20, 10}, {-10, 0}, {0, 20}, {30, 40}}));
    }


    public int solution(int[][] routes) {
        int answer = 0, camera = Integer.MIN_VALUE;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        for (int[] route : routes) {
            if (route[0] > camera) {
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }
}