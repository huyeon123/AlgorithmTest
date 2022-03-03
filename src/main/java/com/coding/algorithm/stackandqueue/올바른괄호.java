package com.coding.algorithm.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {
    /**
     *설명
     *
     * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
     * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
     *
     * 입력
     * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
     *
     * 출력
     * 첫 번째 줄에 YES, NO를 출력한다.
     *
     * 예시 입력 1
     * (()(()))(()
     *
     * 예시 출력 1
     * NO
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.print(solution(str));
    }

    private static String solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if(c == '(') stack.push(1);
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(stack.isEmpty()) return "YES";
        else return "NO";

    }

}
