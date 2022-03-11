package com.coding.algorithm.programmers.dfsandbfs;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 타켓넘버 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(5, solution(new int[]{1, 1, 1, 1, 1}, 3));
        Assertions.assertEquals(2, solution(new int[]{4, 1, 2, 1}, 4));
    }

    Queue<Integer> queue = new LinkedList<>();

    public int solution(int[] numbers, int target) {
        queue.add(numbers[0]);
        queue.add(-numbers[0]);
        BFS(numbers);
        return (int) queue.stream().filter(a -> a == target).count();
    }

    public void BFS(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int temp = queue.poll();
                queue.add(temp + numbers[i]);
                queue.add(temp - numbers[i]);
            }
        }
    }

}
