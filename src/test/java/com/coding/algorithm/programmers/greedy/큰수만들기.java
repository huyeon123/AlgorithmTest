package com.coding.algorithm.programmers.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 큰수만들기 {
    /**
     *
     */

    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals("775841", solution("4177252841", 4));
        Assertions.assertEquals("3234", solution("1231234", 3));
    }

    private static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
