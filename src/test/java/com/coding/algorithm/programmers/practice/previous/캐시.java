package com.coding.algorithm.programmers.practice.previous;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class 캐시 {
    LinkedList<String> cache = new LinkedList<>();
    int cacheMaxSize;
    int processTime = 0;

    @Test
    void test_1(){
//        Assertions.assertEquals(50, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//        Assertions.assertEquals(21, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
//        Assertions.assertEquals(60, solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(25, solution(0, new String[]{"Jeju", "Jeju", "Seoul", "NewYork", "LA"}));
    }

    public int solution(int cacheSize, String[] cities) {
        cacheMaxSize = cacheSize;

        for (String city : cities) {
            fetch(city.toLowerCase());
        }

        return processTime;
    }

    private void fetch(String city) {
        if (cache.contains(city)) {
            cacheHit(city);
        } else {
            cacheMiss(city);
        }
    }

    private void cacheHit(String city) {
        processTime++;
        cache.remove(city);
        cache.add(city);
    }

    private void cacheMiss(String city) {
        processTime += 5;

        if (cacheMaxSize == 0) return;

        if (cache.size() >= cacheMaxSize) {
            cache.poll();
        }
        cache.add(city);
    }
}
