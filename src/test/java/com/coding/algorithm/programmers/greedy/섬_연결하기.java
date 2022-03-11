package com.coding.algorithm.programmers.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 섬_연결하기 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(4, solution(4, new int[][]{
                {0, 1, 1}, //섬번호, 섬번호, 비용
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        }));
        Assertions.assertEquals(1, solution(2, new int[][]{
                {0, 1, 1}, //섬번호, 섬번호, 비용
        }));
//        Assertions.assertEquals(4, solution());
    }

    public class Edge implements Comparable<Edge> {
        public int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }

    public int solution(int n, int[][] costs) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] cost : costs) {
            graph.get(cost[0]).add(new Edge(cost[1], cost[2]));
            graph.get(cost[1]).add(new Edge(cost[0], cost[2]));
        }
        int answer = 0;
        int[] check = new int[n];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(0, 0));
        while (!queue.isEmpty()) {
            Edge temp = queue.poll();
            int endVertex = temp.vertex;
            if (check[endVertex] == 0) {
                check[endVertex] = 1;
                answer += temp.cost;
                for (Edge edge : graph.get(endVertex)) {
                    if(check[edge.vertex] == 0) queue.offer(new Edge(edge.vertex, edge.cost));
                }
            }
        }
        return answer;
    }

}
