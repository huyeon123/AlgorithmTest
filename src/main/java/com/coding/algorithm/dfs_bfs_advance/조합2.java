package com.coding.algorithm.dfs_bfs_advance;

import java.util.*;

public class 조합2 {
    /**
     *1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
     *
     * ▣ 입력설명
     * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
     *
     * ▣ 출력설명
     * 첫 번째 줄에 결과를 출력합니다.
     * 출력순서는 사전순으로 오름차순으로 출력합니다.
     *
     * ▣ 입력예제 1
     * 4 2
     *
     * ▣ 출력예제 1
     * 1 2
     * 1 3
     * 1 4
     * 2 3
     * 2 4
     * 3 4
     */

    static int n,m;
    static int[] combination;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combination = new int[m];

        solution(0, 1);
    }

    //조합은 외우는게 좋음. 응용할 경우가 많아서
    private static void solution(int level, int s) {
        if (level == m) {
            for (int i : combination) {
                System.out.print(i+ " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combination[level] = i;
                solution(level + 1, i + 1);
            }
        }
    }

}
