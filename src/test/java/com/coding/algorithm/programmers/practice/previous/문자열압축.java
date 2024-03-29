package com.coding.algorithm.programmers.practice.previous;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 문자열압축 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(7, solution("aabbaccc"));
        Assertions.assertEquals(17, solution("xababcdcdababcdcd"));
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            String temp = s.substring(0, i);
            int count = 1;
            for (int j = i; j < s.length(); j += i) {
                String substring;
                if (j + i <= s.length()) substring = s.substring(j, j + i);
                else substring = s.substring(j);

                if (temp.equals(substring)) count++;
                else {
                    if (count > 1) sb.append(count);
                    sb.append(temp);
                    temp = substring;
                    count = 1;
                }
            }
            if (count > 1) sb.append(count);
            sb.append(temp);
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }

}
