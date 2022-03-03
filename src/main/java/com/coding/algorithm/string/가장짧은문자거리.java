package com.coding.algorithm.string;

import java.util.Scanner;

public class 가장짧은문자거리 {
    /**
     *설명
     *
     * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     *
     * 문자열의 길이는 100을 넘지 않는다.
     *
     *
     * 출력
     * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     *
     *
     * 예시 입력 1
     *
     * teachermode e
     * 예시 출력 1
     *
     * 1 0 1 2 1 0 1 2 2 1 0
     * */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str = in.next();
        char t = in.next().charAt(0);

        int[] answer = solution(str, t);

        for (int e : answer) {
            System.out.print(e+" ");
        }
    }

    private static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        char[] arr = str.toCharArray();
        int count = 1000;
        for (int i = 0; i < str.length(); i++) {
            if(arr[i] == c){
                answer[i] = count = 0;
            }else{
                answer[i] = ++count;
            }
        }

        for (int i = str.length()-1; i >= 0; i--) {
            if(arr[i] == c){
                answer[i] = count = 0;
            }else{
                if(answer[i] > count+1) answer[i] = ++count;
            }
        }
        return answer;
    }
}
