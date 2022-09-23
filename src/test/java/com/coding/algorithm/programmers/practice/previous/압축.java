package com.coding.algorithm.programmers.practice.previous;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 압축 {
    HashMap<String, Integer> dictionary = new HashMap<>();
    String message;

    @Test
    void test_1() {
//        Assertions.assertArrayEquals(new int[]{11, 1, 27, 15}, solution("KAKAO"));
        Assertions.assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, solution("TOBEORNOTTOBEORTOBEORNOT"));
    }

    public int[] solution(String msg) {
        message = msg;
        return LZW();
    }

    private int[] LZW() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        while (message.length() != 0) {
            String w = getW(String.valueOf(message.charAt(0)));
            Integer integer = dictionary.get(w);
            answer.add(integer);
            message = message.substring(w.length());
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private String getW(String w) {
        if (!dictionary.containsKey(w)) {
            dictionary.put(w, dictionary.size() + 1);
            return w.substring(0, w.length() - 1);
        }

        int startIdx = message.indexOf(w);
        int endIdx = startIdx + w.length() + 1;

        if (endIdx > message.length()) {
            return w;
        }

        String next = message.substring(startIdx, endIdx);
        return getW(next);
    }
}
