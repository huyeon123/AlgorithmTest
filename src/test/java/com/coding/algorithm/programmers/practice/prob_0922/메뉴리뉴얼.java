package com.coding.algorithm.programmers.practice.prob_0922;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 메뉴리뉴얼 {
    Map<String, Integer> table = new HashMap<>();
    List<List<String>> courseMenu = new ArrayList<>();
    int[] courseCount = new int[11];

    @Test
    void test_1() {
        solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }

    public String[] solution(String[] orders, int[] course) {
        init();

        orders = orderSort(orders);

        countMenu(orders, course);

        renewal();

        return getCourseMenu();
    }

    private void init() {
        for (int i = 0; i < courseCount.length; i++) {
            courseMenu.add(new ArrayList<>());
        }
    }

    private String[] orderSort(String[] orders) {
        String[] sortedOrder = new String[orders.length];

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            sortedOrder[i] = new String(chars);
        }

        return sortedOrder;
    }

    private void countMenu(String[] orders, int[] course) {
        for (String order : orders) {
            //subSet
            for (int courseNum : course) {
                boolean[] visited = new boolean[order.length()];
                combination(order, courseNum, visited, 0);
            }
        }
    }

    private void combination(String order, int courseNum, boolean[] visited, int start) {
        if (courseNum == 0) {
            count(order, visited);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            visited[i] = true;
            combination(order, courseNum - 1, visited, i + 1);
            visited[i] = false;
        }
    }

    private void count(String order, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sb.append(order.charAt(i));
            }
        }
        String setMenu = sb.toString();
        table.put(setMenu, table.getOrDefault(setMenu, 0) + 1);
    }

    private void renewal() {
        table.forEach((key, value) -> {
            if (value < 2) {
                return;
            }

            if (value > courseCount[key.length()]) {
                listClear(key.length());
            }

            if (value >= courseCount[key.length()]) {
                courseCount[key.length()] = value;
                courseMenu.get(key.length()).add(key);
            }
        });
    }

    private void listClear(int index) {
        List<String> list = courseMenu.get(index);
        if (!list.isEmpty()) {
            list.clear();
        }
    }

    private String[] getCourseMenu() {
        List<String> result = new ArrayList<>();

        for (List<String> menu : courseMenu) {
            result.addAll(menu);
        }

        result.sort(Comparator.naturalOrder());

        int size = result.size();
        return result.toArray(new String[size]);
    }
}
