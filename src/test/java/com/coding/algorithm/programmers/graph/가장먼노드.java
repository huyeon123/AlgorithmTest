package com.coding.algorithm.programmers.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 가장먼노드 {
    final int INF = Integer.MAX_VALUE;
    Graph graph;
    int n;

    @Test
    void test(){
        assertEquals(3, solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public int solution(int n, int[][] edge) {
        init(n, edge);

        int[] dijkstra = dijkstra(1);

        int max = 0, answer = 0;
        for (int i = 1; i < dijkstra.length; i++) {
            if (dijkstra[i] > max) {
                max = dijkstra[i];
                answer = 0;
                answer++;
                continue;
            }

            if (dijkstra[i] == max) {
                answer++;
            }
        }

        return answer;
    }

    private void init(int n, int[][] edge) {
        this.n = n + 1;
        graph = new Graph(n + 1);

        for (int[] e : edge) {
            graph.put(e[0], e[1], 1);
        }
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
