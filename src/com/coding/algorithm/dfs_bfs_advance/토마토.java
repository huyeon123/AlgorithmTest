package com.coding.algorithm.dfs_bfs_advance;

import java.util.*;

public class 토마토 {
    /**
     *설명
     *
     * 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
     *
     * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
     *
     * Image1.jpg
     *
     * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
     *
     * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
     *
     * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
     *
     * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
     *
     * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
     *
     * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     *
     * 입력
     * 첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수,
     *
     * N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.
     *
     * 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
     *
     * 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
     *
     * 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
     *
     * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
     *
     * 출력
     * 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
     *
     * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
     *
     * 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
     *
     * 예시 입력 1
     * 6 4
     * 0 0 -1 0 0 0
     * 0 0 1 0 -1 0
     * 0 0 -1 0 0 0
     * 0 0 0 0 -1 1
     *
     * 예시 출력 1
     * 4
     */

    static int n, m;
    static int[][] container, dis;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        container = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                container[i][j] = sc.nextInt();
                if(container[i][j] == 1) queue.offer(new Point(i, j));
            }
        }
        solution();
        boolean flag = true;
        int answer = 0;
        //다 익었는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(container[i][j] == 0) flag = false;
            }
        }
        //익은 얘 중 제일 오래된 녀석이 정답
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.print(answer);
        }
        else System.out.println(-1);
    }

    private static void solution() {
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx>=0 && nx<n && ny>=0 && ny<m && container[nx][ny]==0) {
                    container[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; //날짜 카운트
                }
            }
        }
    }

}
