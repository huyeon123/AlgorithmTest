package com.coding.algorithm.dynamic;

import java.util.*;

public class 계단오르기 {
    /**
     * 설명
     * <p>
     * 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
     * <p>
     * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
     * <p>
     * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
     * <p>
     * Image1.jpg
     * <p>
     * <p>
     * 입력
     * 첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 올라가는 방법의 수를 출력합니다.
     * <p>
     * 예시 입력 1
     * 7
     * <p>
     * 예시 출력 1
     * 21
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(solution(n));
    }

    private static int solution(int n) {
        int[] dynamic_table = new int[n + 1];
        dynamic_table[1] = 1;
        dynamic_table[2] = 2;
        for (int i = 3; i <= n; i++) {
            dynamic_table[i] = dynamic_table[i-1] + dynamic_table[i-2];
        }
        return dynamic_table[n];
    }

}
