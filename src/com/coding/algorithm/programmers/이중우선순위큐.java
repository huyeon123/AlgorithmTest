package com.coding.algorithm.programmers;

import java.util.*;

public class 이중우선순위큐 {
    /**
     *
     */
    public static void main(String[] args) {
        이중우선순위큐 T = new 이중우선순위큐();
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        String[] operations2 = {"I 16", "D 1"};
        String[] operations3 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] operations4 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        for (int i : T.solution(operations)) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : T.solution(operations2)) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : T.solution(operations3)) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : T.solution(operations4)) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int num = Integer.parseInt(split[1]);

            if (command.equals("I")) {
                minHeap.add(num);
                maxHeap.add(num);
            } else {
                if(minHeap.isEmpty()) continue;
                if (num == 1) {
                    minHeap.remove(maxHeap.poll());
                } else if (num == -1) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }
}
