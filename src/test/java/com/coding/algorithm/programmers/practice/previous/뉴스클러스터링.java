package com.coding.algorithm.programmers.practice.previous;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 뉴스클러스터링 {
    double intersection = 0;

    @Test
    void test_1() {
//        Assertions.assertEquals(16384, solution("FRANCE", "french"));
//        Assertions.assertEquals(65536, solution("handshake", "shake hands"));
        Assertions.assertEquals(43690, solution("aa1+aa2", "AAAA12"));
    }

    public int solution(String str1, String str2) {
        List<String> set1 = splitString(str1.toLowerCase());
        List<String> set2 = splitString(str2.toLowerCase());

        if (set1.isEmpty() && set2.isEmpty()) {
            return 65536;
        }

        intersection(set1, set2);
        double union = union(set1, set2);
        double jacquard = intersection / union;

        return (int) (jacquard * 65536);
    }

    private double union(List<String> set1, List<String> set2) {
        return set1.size() + set2.size() + intersection;
    }

    private List<String> splitString(String str) {
        int length = str.length();
        List<String> newSet = new ArrayList<>();

        for (int i = 0; i < length - 1; i++) {
            String substring = str.substring(i, i + 2);
            if (substring.matches("[a-z]+")) {
                newSet.add(substring);
            }
        }

        return newSet;
    }

    private void intersection(List<String> set1, List<String> set2) {
        Iterator<String> iterator = set1.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();

            if(set2.contains(str)) {
                set2.remove(str);
                iterator.remove();
                intersection++;
            }
        }
    }
}
