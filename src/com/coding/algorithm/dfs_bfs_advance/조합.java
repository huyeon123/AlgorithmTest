package com.coding.algorithm.dfs_bfs_advance;

import java.util.*;

public class 조합 {
    /**
     * nCr = n-1 C r-1 + n-1 C r 을 사용하여 재귀를 이용해 조합 수를 구해주는 프로그램을 작성하세요.
     *
     * 입력
     * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
     *
     * 출력
     * 첫째 줄에 조합수를 출력합니다.
     *
     * 예시 입력 1
     * 5 3
     *
     * 예시 출력 1
     * 10
     *
     * 예시 입력 2
     * 33 19
     *
     * 예시 출력 2
     * 818809200
     */

    static int[][] mem = new int[34][34];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.print(solution(n, r));
    }

    private static int solution(int n, int r) {
        if(mem[n][r] > 0) return mem[n][r]; //Memoization
        if (n==r || r==0) {
            return 1;
        } else {
            return mem[n][r] = solution(n - 1, r - 1) + solution(n - 1, r); //Memoization
        }
    }

}
