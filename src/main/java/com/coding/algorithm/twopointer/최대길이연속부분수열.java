package com.coding.algorithm.twopointer;

import java.util.Scanner;

public class 최대길이연속부분수열 {
    /**
     * 설명
     * <p>
     * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
     * <p>
     * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
     * <p>
     * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
     * <p>
     * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
     * <p>
     * Image1.jpg
     * <p>
     * 이며 그 길이는 8입니다.
     * <p>
     * 입력
     * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
     * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
     * <p>
     * 출력
     * 첫 줄에 최대 길이를 출력하세요.
     * <p>
     * 예시 입력 1
     * 14 2
     * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
     * <p>
     * 예시 출력 1
     * 8
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
        int answer = 0, count = 0, lt = 0, rt = 0;
        while (lt < n && rt < n) {
            if (arr[rt] == 0) count++;
            while (count > k) {
                if(arr[lt] == 0) count--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
            rt++;
        }
        return answer;
    }

}
