package com.coding.algorithm.dfs_bfs_advance;

import java.util.*;

public class 순열구하기 {
    /**
     *10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
     *
     * ▣ 입력설명
     * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
     * 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
     *
     * ▣ 출력설명
     * 첫 번째 줄에 결과를 출력합니다.
     * 출력순서는 사전순으로 오름차순으로 출력합니다.
     *
     * ▣ 입력예제 1
     * 3 2
     * 3 6 9
     *
     * ▣ 출력예제 1
     * 3 6
     * 3 9
     * 6 3
     * 6 9
     * 9 3
     * 9 6
     */

    static int n,m;
    static int[] arr, check, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        check = new int[n];
        answer = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(0);
    }

    private static void solution(int level) {
        if (level == m) {
            for (int i : answer) System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    answer[level] = arr[i];
                    solution(level + 1);
                    check[i] = 0;
                }
            }
        }
    }

}
