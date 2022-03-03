package com.coding.algorithm.mapandhash;

import java.util.*;

public class 매출액의종류 {
    /**
     * 설명
     * <p>
     * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
     * <p>
     * 각 구간별로 구하라고 했습니다.
     * <p>
     * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
     * <p>
     * 20 12 20 10 23 17 10
     * <p>
     * 각 연속 4일간의 구간의 매출종류는
     * <p>
     * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
     * <p>
     * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
     * <p>
     * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
     * <p>
     * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
     * <p>
     * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
     * <p>
     * 매출액의 종류를 출력하는 프로그램을 작성하세요.
     * <p>
     * <p>
     * 입력
     * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
     * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
     * <p>
     * 출력
     * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
     * <p>
     * 예시 입력 1
     * 7 4
     * 20 12 20 10 23 17 10
     * <p>
     * 예시 출력 1
     * 3 4 4 3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solution(n, k, arr).forEach(x -> System.out.print(x + " "));
    }

    private static List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;
    }

//    Time Limit Error 2회 : answer += map.size() + " " <<< 캐스팅 연산이 오래걸리나봄 (차이 심각하게 많이남;;)
//    private static String solution(int n, int k, int[] arr) {
//        String answer = "";
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < k; i++) {
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        }
//        answer += map.size() + " ";
//        for (int i = 0; i < n - k; i++) {
//            map.put(arr[k + i], map.getOrDefault(arr[k + i], 0) + 1);
//            map.put(arr[i], map.get(arr[i]) - 1);
//            if(map.get(arr[i]) == 0) map.remove(arr[i]);
//            answer += map.size() + " ";
//        }
//
//        return answer;
//    }

}
