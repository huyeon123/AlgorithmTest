package com.coding.algorithm.programmers.dfsandbfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(4, solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        Assertions.assertEquals(0, solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    Queue<String> queue = new LinkedList<>();
    boolean[] check;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        queue.add(begin);
        BFS(0, target, words);
        return answer;
    }

    public void BFS(int level, String target, String[] words) {
        for (int i = 0; i < queue.size(); i++) {
            String str = queue.poll();
            if (str.equals(target)) answer = Math.min(level, answer);
            for (int j = 0; j < words.length; j++) {
                if (!check[j]) {
                    int count = 0;
                    for (int k = 0; k < words[j].toCharArray().length; k++) {
                        if (words[j].charAt(k) != str.charAt(k)) count++;
                    }
                    if (count == 1) {
                        queue.add(words[j]);
                        check[j] = true;
                    }
                }
            }
        }
        if (!queue.isEmpty()) BFS(level + 1, target, words);
        if (answer == Integer.MAX_VALUE) answer = 0;
    }

}
