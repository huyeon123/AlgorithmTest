package com.coding.algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 단어뒤집기 {
    /**
     * 설명
     *
     * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
     *
     * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
     *
     *
     * 출력
     * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
     *
     *
     * 예시 입력 1
     * 3
     * good
     * Time
     * Big
     *
     * 예시 출력 1
     * doog
     * emiT
     * giB
     * */

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int count = in.nextInt();
        String[] str = new String[count];
        for (int i = 0; i < count; i++) {
            str[i] = in.next();
        }

        for (String s : solution(count, str)) {
            System.out.println(s);
        }
    }

    private static List<String> solution(int count, String[] str) {
        List<String> answer = new ArrayList<>();
        for (String s : str) {
            answer.add(new StringBuilder(s).reverse().toString());
        }
        return answer;
    }
}
