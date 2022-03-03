package com.coding.algorithm.dfs_bfs_basic;

import java.util.*;

public class 경로탐색_인접리스트 {
    /**
     *
     */
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[n + 1];
        for (int i = 0; i < m; i++) {
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
        check[1] = 1;

        System.out.print(solution(1));
    }

    private static int solution(int v) {
        if(v == n) answer++;
        else{
            for (int nv : graph.get(v)) {
                if (check[nv] == 0) {
                    check[nv] = 1;
                    solution(nv);
                    check[nv] = 0;
                }
            }
        }
        return answer;
    }

}
