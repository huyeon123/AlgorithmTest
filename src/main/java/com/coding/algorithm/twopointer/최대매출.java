package com.coding.algorithm.twopointer;

import java.util.Scanner;

public class 최대매출 {
    /**
     * 설명
     * <p>
     * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
     * <p>
     * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
     * <p>
     * 12 15 11 20 25 10 20 19 13 15
     * <p>
     * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
     * <p>
     * 여러분이 현수를 도와주세요.
     * <p>
     * 입력
     * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
     * <p>
     * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
     * <p>
     * 출력
     * 첫 줄에 최대 매출액을 출력합니다.
     * <p>
     * 예시 입력 1
     * 10 3
     * 12 15 11 20 25 10 20 19 13 15
     * <p>
     * 예시 출력 1
     * 56
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.print(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int answer = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            answer += arr[i];
        }
        sum = answer;
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i-k];
            if(sum > answer) answer = sum;
        }
        return answer;
    }


}
