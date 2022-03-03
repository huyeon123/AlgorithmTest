package com.coding.algorithm.dfs_bfs_basic;

import java.util.*;

public class 그래프최단거리 {
    /**
     * 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
     * <p>
     * ▣ 입력설명
     * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
     * 결정보가 주어진다.
     * <p>
     * ▣ 출력설명
     * 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
     * <p>
     * ▣ 입력예제 1
     * 6 9
     * 1 3
     * 1 4
     * 2 1
     * 2 5
     * 3 4
     * 4 5
     * 4 6
     * 6 2
     * 6 5
     * <p>
     * ▣ 출력예제 1
     * 2 : 3
     * 3 : 1
     * 4 : 1
     * 5 : 2
     * 6 : 2
     */
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check, dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
        check[1] = 1;
        solution(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    private static void solution(int v) {
        Queue<Integer> queue = new LinkedList<>();
        check[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (check[nv] == 0) {
                    check[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

}
