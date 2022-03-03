package com.coding.algorithm.string;

import java.util.Scanner;

public class 특정문자뒤집기 {
    /**
     * 설명
     * <p>
     * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * <p>
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * <p>
     * <p>
     * 입력
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * <p>
     * <p>
     * 출력
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     * <p>
     * <p>
     * 예시 입력 1
     * <p>
     * a#b!GE*T@S
     * 예시 출력 1
     * <p>
     * S#T!EG*b@a
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        System.out.print(solution(str));
    }

    private static String solution(String str) {
        char[] answer = str.toCharArray();
        int lp = 0;
        int rp = str.length() - 1;

        while (lp < rp) {
            if(!Character.isAlphabetic(answer[lp])) lp++;
            else if(!Character.isAlphabetic(answer[rp])) rp--;
            else{
                char temp = answer[lp];
                answer[lp++] = answer[rp];
                answer[rp--] = temp;
            }
        }
        return new String(answer);
    }
}
