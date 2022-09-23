package com.coding.algorithm.programmers.practice.previous;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 점프와순간이동 {
    @Test
    void test_1(){
        Assertions.assertEquals(2, solution(5));
        Assertions.assertEquals(2, solution(6));
        Assertions.assertEquals(5, solution(5000));
        Assertions.assertEquals(5, solution(1_000_000_000));
        Assertions.assertEquals(1, solution(1));
    }

    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 != 0) {
                ans++;
            }
            n /= 2;
        }

        return ans;
    }
}
