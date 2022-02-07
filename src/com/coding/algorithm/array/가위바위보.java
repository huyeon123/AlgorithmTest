package com.coding.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가위바위보 {
    /**
     *설명
     *
     * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
     *
     * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
     *
     * 예를 들어 N=5이면
     *
     * Image1.jpg
     *
     * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
     *
     * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     *
     * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     *
     *
     * 출력
     * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 5
     * 2 3 3 1 3
     * 1 1 2 2 3
     *
     * 예시 출력 1
     *
     * A
     * B
     * A
     * B
     * D
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr_A = new int[n];
        int[] arr_B = new int[n];
        for (int i = 0; i < n; i++) {
            arr_A[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr_B[i] = in.nextInt();
        }

        solution(n, arr_A, arr_B).forEach(System.out::println);
    }

    private static List<String> solution(int n, int[] A, int[] B) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(A[i] == B[i]) answer.add("D");
            else if(A[i] == 1 && B[i] == 2) answer.add("B");
            else if(A[i] == 2 && B[i] == 3) answer.add("B");
            else if(A[i] == 3 && B[i] == 1) answer.add("B");
            else answer.add("A");
        }
        return answer;
    }

    /**
     * A
     * B
     * A
     * D
     * A
     * D
     * A
     * B
     * A
     * A */

    /**
     * A
     B
     A
     D
     A
     D
     A
     B
     A
     A
     * */


}
