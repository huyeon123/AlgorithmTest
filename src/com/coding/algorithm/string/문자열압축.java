package com.coding.algorithm.string;

import java.util.Scanner;

public class 문자열압축 {
    /**
     * 설명
     * <p>
     * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
     * <p>
     * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     * <p>
     * 단 반복횟수가 1인 경우 생략합니다.
     * <p>
     * <p>
     * 입력
     * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     * <p>
     * <p>
     * 출력
     * 첫 줄에 압축된 문자열을 출력한다.
     * <p>
     * <p>
     * 예시 입력 1
     * KKHSSSSSSSE
     * 예시 출력 1
     * K2HS7E
     * <p>
     * 예시 입력 2
     * KKTFFFFFFEEE
     * 예시 출력 2
     * K2TF6E3
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        System.out.println(solution(str));

    }

    private static String solution(String str) {
        String answer = "" + str.charAt(0);
        int count = 1;
        char[] arr = str.toCharArray();
        for (int i = 1; i < str.length(); i++) {
            if (i == str.length()-1) answer += Integer.toString(++count);
            if (arr[i] == arr[i - 1]) count++;
            else{
                if(count > 1){
                    answer += Integer.toString(count);
                    count = 1;
                }
                answer += arr[i];
            }
        }
        return answer;
    }
}
