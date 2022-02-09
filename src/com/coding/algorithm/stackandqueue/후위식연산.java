package com.coding.algorithm.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {
    /**
     * 설명
     * <p>
     * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
     * <p>
     * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
     * <p>
     * <p>
     * 입력
     * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
     * <p>
     * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
     * <p>
     * <p>
     * 출력
     * 연산한 결과를 출력합니다.
     * <p>
     * 예시 입력 1
     * 352+*9-
     * <p>
     * 예시 출력 1
     * 12
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.print(solution(str));
    }

    private static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) stack.push(Integer.parseInt(String.valueOf(c)));
            else {
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                if (c == '+') stack.push(tmp1 + tmp2);
                else if (c == '-') stack.push(tmp1 - tmp2);
                else if (c == '*') stack.push(tmp1 * tmp2);
                else if (c == '/') stack.push(tmp1 / tmp2);
            }
        }
        return stack.pop();
    }

}
