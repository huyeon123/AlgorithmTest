package com.coding.algorithm.programmers.practice.prob_0922;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N진수게임 {
    int[] arr = new int[16 * 16 * 16 * 16];
    String[] arrN = new String[arr.length];
    List<String> allNumber = new ArrayList<>();

    @Test
    void test_1() {
        Assertions.assertEquals("0111", solution(2, 4, 2, 1));
        Assertions.assertEquals("02468ACE11111111", solution(2, 4, 2, 1));
        Assertions.assertEquals("0111", solution(2, 4, 2, 1));
    }

    public String solution(int n, int t, int m, int p) {
        init();

        toRadix(n);
        split();

        return getExpect(t, m, p);
    }

    private void init() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    private void toRadix(int n) {
        for (int i = 0; i < arr.length; i++) {
            arrN[i] = Integer.toString(i, n);
        }
    }

    private void split() {
        allNumber = Arrays.stream(arrN)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    private String getExpect(int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String expect = allNumber.get((m * i + p) - 1);
            answer.append(expect.toUpperCase());
        }

        return answer.toString();
    }

}
