package com.coding.algorithm.programmers.practice.prob_0922;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 합승택시요금 {

    final int INF = 100_000 * 200;
    Graph graph;
    int[] startToCommon;
    int n;

    @Test
    void test_1() {
        solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(n, fares);
        startToCommon = dijkstra(s);

        int answer = INF;
        for (int commonVertex = 1; commonVertex < n + 1; commonVertex++) {
            int cost = 0;
            cost += startToCommon[commonVertex];
            cost += getCost(commonVertex, a);
            cost += getCost(commonVertex, b);
            answer = Math.min(cost, answer);
        }

        return answer;
    }

    private void init(int n, int[][] fares) {
        this.n = n + 1;
        graph = new Graph(n + 1);

        for (int[] fare : fares) {
            graph.put(fare[0], fare[1], fare[2]);
        }
    }

    private int getCost(int startVertex, int endVertex) {
        int[] dijkstra = dijkstra(startVertex);
        return dijkstra[endVertex];
    }

    private int[] dijkstra(int startVertex) {
        int[] dis = new int[n];
        boolean[] isVisited = new boolean[n];
        Arrays.fill(dis, INF);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startVertex, 0));
        dis[startVertex] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNode = cur.getNode();
            int curWeight = cur.getWeight();

            if (curWeight > dis[curNode]) continue;

            if (!isVisited[curNode]) {
                isVisited[curNode] = true;
                List<Node> nodeList = graph.getNodeList(curNode);

                for (Node node : nodeList) {
                    int nextNode = node.getNode();
                    int nextWeight = node.getWeight();

                    if (!isVisited[nextNode] && dis[nextNode] > curWeight + nextWeight) {
                        dis[nextNode] = curWeight + nextWeight;
                        queue.add(new Node(nextNode, dis[nextNode]));
                    }
                }
            }
        }

        return dis;
    }

    class Node implements Comparable<Node> {
        private final int node;
        private final int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    class Graph {
        private final List<List<Node>> graph;

        public Graph(int nodeSize) {
            graph = new ArrayList<>();
            for (int i = 0; i < nodeSize; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Node> getNodeList(int n) {
            return graph.get(n);
        }

        public void put(int n, int m, int weight) {
            graph.get(n).add(new Node(m, weight));
            graph.get(m).add(new Node(n, weight));
        }
    }

}
