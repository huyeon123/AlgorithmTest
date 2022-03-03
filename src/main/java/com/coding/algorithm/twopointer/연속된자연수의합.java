package com.coding.algorithm.twopointer;

import java.util.Scanner;

public class 연속된자연수의합 {
    /**
     * 설명
     * <p>
     * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
     * <p>
     * 만약 N=15이면
     * <p>
     * 7+8=15
     * <p>
     * 4+5+6=15
     * <p>
     * 1+2+3+4+5=15
     * <p>
     * 와 같이 총 3가지의 경우가 존재한다.
     * <p>
     * 입력
     * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
     * <p>
     * 출력
     * 첫 줄에 총 경우수를 출력합니다.
     * <p>
     * 예시 입력 1
     * 15
     * <p>
     * 예시 출력 1
     * 3
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.print(solution(n));
    }

    private static int solution(int n) {
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = i + 1;
        }

        int lt = 0, rt = 0, answer = 0, sum = 0;

        while (lt < n && rt < n) {
            if (sum < n) sum += number[rt++];
            else if (sum > n) sum -= number[lt++];
            if (sum == n) {
                answer++;
                sum -= number[lt++];
            }
        }
        return answer;
    }

}
