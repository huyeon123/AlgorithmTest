package com.coding.algorithm.dynamic;

import java.util.*;

public class 동전교환 {
    /**
     *설명
     *
     * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
     *
     * 각 단위의 동전은 무한정 쓸 수 있다.
     *
     *
     * 입력
     * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
     *
     * 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
     *
     * 각 동전의 종류는 100원을 넘지 않는다.
     *
     *
     * 출력
     * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
     *
     *
     * 예시 입력 1
     * 3
     * 1 2 5
     * 15
     *
     * 예시 출력 1
     * 3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.print(solution(n, arr, m));
    }

    private static int solution(int n, int[] arr, int m) {
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1);
            }
        }
        return dy[m];
    }

}
