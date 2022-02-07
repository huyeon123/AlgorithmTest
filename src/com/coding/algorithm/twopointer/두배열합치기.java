package com.coding.algorithm.twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 두배열합치기 {
    /**
     * 설명
     * <p>
     * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
     * <p>
     * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
     * <p>
     * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
     * <p>
     * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
     * <p>
     * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
     * <p>
     * 출력
     * 오름차순으로 정렬된 배열을 출력합니다.
     * <p>
     * 예시 입력 1
     * 3
     * 1 3 5
     * 5
     * 2 3 6 7 9
     * <p>
     * 예시 출력 1
     * 1 2 3 3 5 6 7 9
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }

        System.out.print(solution(arr1, arr2));
        solution2(arr1,arr2).forEach(x -> System.out.print(x+" "));
    }

    private static String solution(int[] arr1, int[] arr2) {
        int cnt1 = 0, cnt2 = 0;
        String answer = "";
        while (true) {
            if(arr1[cnt1] <= arr2[cnt2]) {
                answer += arr1[cnt1++] + " ";
            }else{
                answer += arr2[cnt2++] + " ";
            }
            if(cnt1 == arr1.length){
                for (int i = cnt2; i < arr2.length; i++) {
                    answer += arr2[i] + " ";
                }
                break;
            }
            if(cnt2 == arr2.length){
                for (int i = cnt1; i < arr1.length; i++) {
                    answer += arr1[i] + " ";
                }
                break;
            }

        }
        return answer;
    }

    private static List<Integer> solution2(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        for (int j : arr1) answer.add(j);
        for (int j : arr2) answer.add(j);
        Collections.sort(answer);
        return answer;
    }

}
