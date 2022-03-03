package com.coding.algorithm.dynamic;

import java.util.*;

public class 돌다리건너기 {
    /**
     * 설명
     * <p>
     * 철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
     * <p>
     * 철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
     * <p>
     * 철수가 개울을 건너는 방법은 몇 가지일까요?
     * <p>
     * Image1.jpg
     * <p>
     * <p>
     * 입력
     * 첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.
     * <p>
     * 예시 입력 1
     * 7
     * <p>
     * 예시 출력 1
     * 34
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(solution(n));
    }

    private static int solution(int n) {
        int[] dy = new int[n + 2];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n + 1]; //개울을 건너는 것이기 때문에 마지막 돌다리에 왔다고 해서 도착한 것이 아님
    }

}
