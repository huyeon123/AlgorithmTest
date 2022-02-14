package com.coding.algorithm.dfs_bfs_basic;

import java.util.*;

public class 경로탐색_인접행렬 {
    /**
     *방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프
     * 로그램을 작성하세요.
     *
     * 입력설명
     * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
     * 결정보가 주어진다.
     *
     * ▣ 출력설명
     * 총 가지수를 출력한다.
     *
     * ▣ 입력예제 1
     * 5 9
     * 1 2
     * 1 3
     * 1 4
     * 2 1
     * 2 3
     * 2 5
     * 3 4
     * 4 2
     * 4 5
     *
     * ▣ 출력예제 1
     * 6
     */

    static int n, m, answer = 0;
    static int[] check;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new int[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) graph[sc.nextInt()][sc.nextInt()] = 1;
        check[1] = 1;

        System.out.print(solution(1));
    }

    private static int solution(int v) {
        if(v == n) answer++;
        else{
            for (int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && check[i] == 0){
                    check[i] = 1;
                    solution(i);
                    check[i] = 0; //Back 하면서 기존 체크 해제
                }
            }
        }
        return answer;
    }

}
