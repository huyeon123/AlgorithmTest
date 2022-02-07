package com.coding.algorithm.array;

import java.util.Scanner;

public class 소수 {
    /**
     *설명
     *
     * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
     *
     * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
     *
     *
     * 입력
     * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
     *
     *
     * 출력
     * 첫 줄에 소수의 개수를 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 20
     * 예시 출력 1
     *
     * 8
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.print(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) answer++;
        }
        return answer;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i*i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

}
