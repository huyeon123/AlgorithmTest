package com.coding.algorithm.programmers.practice.previous;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 로또 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertArrayEquals(new int[]{3, 5}, solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));
        Assertions.assertArrayEquals(new int[]{1, 6}, solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}));
        Assertions.assertArrayEquals(new int[]{1, 1}, solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lottosList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNums = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int zeroCount = 0, answerCount = 0;
        int[] answer = new int[2];

        for (Integer integer : lottosList) {
            if (integer == 0) zeroCount++;
            else if (winNums.contains(integer)) answerCount++;
        }

        answer[1] = rank(answerCount);
        answerCount += zeroCount;
        if(answerCount > 6) answerCount = 6;
        answer[0] = rank(answerCount);

        return answer;
    }

    public int rank(int count){
        switch (count){
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 6;
        }
    }

}
