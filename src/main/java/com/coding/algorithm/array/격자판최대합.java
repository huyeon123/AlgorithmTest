package com.coding.algorithm.array;

import java.util.Scanner;

public class 격자판최대합 {
    /**
     * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
     * <p>
     * Image1.jpg
     * <p>
     * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
     * <p>
     * <p>
     * 입력
     * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     * <p>
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     * <p>
     * <p>
     * 출력
     * 최대합을 출력합니다.
     * <p>
     * <p>
     * 예시 입력 1
     * <p>
     * 5
     * 10 13 10 12 15
     * 12 39 30 23 11
     * 11 25 50 53 15
     * 19 27 29 37 27
     * 19 13 30 13 19
     * 예시 출력 1
     * <p>
     * 155
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.print(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int answer = 0;
        int columnSum = 0, rowSum = 0, leftDiagonalSum = 0;
        int row = n - 1;
        int rightDiagonalSum = 0;
        //각 행합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                columnSum += arr[i][j];
                rowSum += arr[j][i];
                if (i == j) leftDiagonalSum += arr[i][j];
            }
            rightDiagonalSum += arr[i][row--];
            if (columnSum > answer) answer = columnSum;
            if (rowSum > answer) answer = rowSum;
            columnSum = rowSum = 0;
        }
        if(leftDiagonalSum > answer) answer = leftDiagonalSum;
        if(rightDiagonalSum > answer) answer = rightDiagonalSum;
        return answer;
    }

}
