package com.coding.algorithm.programmers.practice.previous;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class k진수에서_소수개수_구하기 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(3, solution(437674, 3));
        Assertions.assertEquals(2, solution(110011, 10));
    }

    public int solution(int n, int k) {
        int answer = 0;
        int ps = 0;
        String number;

        if (k < 10) number = convertK(n, k);
        else number = String.valueOf(n);

        char[] arr = number.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '0') {
                long temp = Long.parseLong(number.substring(ps, i)); //진법 변환시 길어질 수 있으므로 int가 아닌 long으로 사용
                if(isPrime(temp)) answer++;
                ps = i;
            }
            if(i == arr.length - 1){
                long temp = Long.parseLong(number.substring(ps, arr.length));
                if(isPrime(temp)) answer++;
            }
        }
        return answer;
    }

    public String convertK(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int share = n / k;
            int remainder = n % k;
            sb.insert(0, remainder);
            n = share;
        }
        return sb.toString();
    }

    public boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
