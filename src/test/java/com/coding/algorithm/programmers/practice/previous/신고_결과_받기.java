package com.coding.algorithm.programmers.practice.previous;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 신고_결과_받기 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertArrayEquals(new int[]{2, 1, 1, 0}, solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2));
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> reportTable = new HashMap<>();
        HashMap<String, Integer> idx = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportTable.put(id_list[i], new HashSet<>());
            idx.put(id_list[i], i);
        }

        for (String s : report) {
            String[] token = s.split(" ");
            reportTable.get(token[1]).add(token[0]);
        }

        for (Set<String> value : reportTable.values()) {
            if(value.size() >= k){
                for (String s : value) {
                    answer[idx.get(s)]++;
                }
            }
        }

        return answer;
    }

}
