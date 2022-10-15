package com.coding.algorithm.programmers.bruteforce;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 전력망 {
    boolean[][] connect;
    int n;
    @Test
    void run(){
        assertEquals(3, solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }

    public int solution(int n, int[][] wires) {
        init(n, wires);

        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            answer = Math.min(answer, diff(wire));
        }

        return answer;
    }

    private void init(int n, int[][] wires) {
        this.n = n;
        connect = new boolean[n][n];
        for (int[] wire : wires) {
            int A = wire[0] - 1;
            int B = wire[1] - 1;
            connect[A][B] = true;
            connect[B][A] = true;
        }
    }

    private int diff(int[] wire) {
        int A = wire[0] - 1;
        int B = wire[1] - 1;

        toggle(A, B);

        int aCount = connectCount(A);
        int bCount = n - aCount;

        toggle(A, B);

        return Math.abs(aCount - bCount);
    }

    private void toggle(int A, int B) {
        connect[A][B] = !connect[A][B];
        connect[B][A] = !connect[B][A];
    }

    private int connectCount(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        queue.add(start);

        int count = 1;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            isVisited[cur] = true;

            for (int i = 0; i < connect[cur].length; i++) {
                if (connect[cur][i] && !isVisited[i]) {
                    count++;
                    queue.add(i);
                }
            }
        }

        return count;
    }
}
