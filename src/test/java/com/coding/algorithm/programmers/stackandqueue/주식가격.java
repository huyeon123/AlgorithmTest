package com.coding.algorithm.programmers.stackandqueue;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        주식가격 T = new 주식가격();
        int[] prices = {1, 2, 3, 2, 3, 4, 3, 2, 1};
        for (int i : T.solution(prices)) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        return answer;
    }
}
