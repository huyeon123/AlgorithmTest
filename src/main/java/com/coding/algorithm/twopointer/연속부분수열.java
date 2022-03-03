package com.coding.algorithm.twopointer;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Scanner;

public class 연속부분수열 {
    /**
     * 설명
     * <p>
     * N개의 수로 이루어진 수열이 주어집니다.
     * <p>
     * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
     * <p>
     * 만약 N=8, M=6이고 수열이 다음과 같다면
     * <p>
     * 1 2 1 3 1 1 1 2
     * <p>
     * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
     * <p>
     * 입력
     * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
     * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
     * <p>
     * 출력
     * 첫째 줄에 경우의 수를 출력한다.
     * <p>
     * 예시 입력 1
     * 8 6
     * 1 2 1 3 1 1 1 2
     * <p>
     * 예시 출력 1
     * 3
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.print(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int lt = 0, rt = 0, answer = 0, sum = 0;
        while (lt < n && rt < n) {
            if (sum < m) sum += arr[rt++];
            else if (sum > m) sum -= arr[lt++];
            if (sum == m){
                answer++;
                sum -= arr[lt++];
            }
        }
        return answer;
    }


}
