package com.coding.algorithm.programmers.practice.prob_0922;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 순위검색 {
    final int P_NUM = 4;
    Map<String, List<Integer>> table = new HashMap<>();
    int[] answer;
    int idx = 0;

    @Test
    void test_1() {
        solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
    }

    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];

        for (String i : info) {
            String[] applicantInfo = i.split(" ");
            int score = Integer.parseInt(applicantInfo[P_NUM]);
            putInfo(applicantInfo, score, 0, "");
        }

        sort();

        for (String q : query) {
            search(q);
        }

        return answer;
    }

    private void putInfo(String[] info, int score, int pCount, String key) {
        if (pCount == P_NUM) {
            if (!table.containsKey(key)) table.put(key, new ArrayList<>());
            table.get(key).add(score);
            return;
        }

        putInfo(info, score, pCount + 1, key + info[pCount]);
        putInfo(info, score, pCount + 1, key + "-");
    }

    private void sort() {
        table.values().forEach(list -> list.sort(Comparator.naturalOrder()));
    }

    private void search(String query) {
        query = query.replaceAll(" and ", "");
        String[] split = query.split(" ");
        int minScore = Integer.parseInt(split[1]);

        if (!table.containsKey(split[0])) {
            answer[idx++] = 0;
            return;
        }

        List<Integer> list = table.get(split[0]);
        int ls = 0, rs = list.size() - 1;

        while (ls <= rs) {
            int mid = (ls + rs) / 2;
            if (list.get(mid) < minScore) {
                ls = mid + 1;
            } else {
                rs = mid - 1;
            }
        }

        answer[idx++] = list.size() - ls;
    }
}
