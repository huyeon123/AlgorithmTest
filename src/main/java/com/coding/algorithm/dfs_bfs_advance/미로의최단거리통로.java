package com.coding.algorithm.dfs_bfs_advance;

import java.util.*;

public class 미로의최단거리통로 {
    /**
     *설명
     *
     * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
     *
     * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
     *
     * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
     *
     * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
     *
     * Image1.jpg
     *
     * 위와 같은 경로가 최단 경로의 길이는 12이다.
     *
     * 입력
     * 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
     *
     * 출력
     * 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
     *
     * 예시 입력 1
     * 0 0 0 0 0 0 0
     * 0 1 1 1 1 1 0
     * 0 0 0 1 0 0 0
     * 1 1 0 1 0 1 1
     * 1 1 0 1 0 0 0
     * 1 0 0 0 1 0 0
     * 1 0 1 0 0 0 0
     *
     * 예시 출력 1
     * 12
     */
    static int[][] board = new int[8][8];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE, count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        solution(1, 1);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.print(answer);
    }

    private static void solution(int x, int y) {
        if(count > answer) return;
        if (x == 7 && y == 7) {
            answer = count;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    count++;
                    solution(nx, ny);
                    board[nx][ny] = 0;
                    count--;
                }
            }
        }
    }

}
