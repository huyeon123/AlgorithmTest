package com.coding.algorithm.greedy;

import java.util.*;

public class 원더랜드_Prim {
    /**
     * Prim's Algorithm은 시작 Vertex와 상관없이 항상 같은 트리를 생성한다.
     */
    public static class Edge implements Comparable<Edge> {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        int[] check = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(1, 0));
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
        System.out.println(answer);
    }
}
