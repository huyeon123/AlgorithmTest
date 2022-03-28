package com.coding.algorithm.programmers.practice;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 다단계_칫솔_판매 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertArrayEquals(new int[]{360, 958, 108, 0, 450, 18, 180, 1080},
                solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String[]{"young", "john", "tod", "emily", "mary"},
                        new int[]{12, 4, 2, 5, 10}));
//        Assertions.assertEquals(0, solution());
    }

    LinkedHashMap<String, Integer> nameToIdx = new LinkedHashMap<>();
    int[] answer;
    String[] ref;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        ref = referral;
        for (int i = 0; i < enroll.length; i++) nameToIdx.put(enroll[i], i);

        for (int i = 0; i < seller.length; i++) {
            int idx = nameToIdx.get(seller[i]);
            int sellPrice = amount[i] * 100;
            answer[idx] += sellPrice;
            operation(idx, sellPrice / 10);
        }

        return answer;
    }

    public void operation(int idx, int price) {
        if (price >= 1) {
            answer[idx] -= price;
            if (!ref[idx].equals("-")) {
                answer[idx] -= price;
                int refIdx = nameToIdx.get(ref[idx]);
                answer[refIdx] += price;
                operation(refIdx, price / 10);
            }
        }
    }
}
