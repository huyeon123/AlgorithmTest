package com.coding.algorithm.programmers.stackandqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 올바른괄호 {
    Stack<Character> stack = new Stack<>();

    @Test
    void test_1() {
        Assertions.assertTrue(solution("(())()"));
        Assertions.assertFalse(solution(")()("));
    }

    boolean solution(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (doProcessAndIfFail(c)) return false;
        }
        return stack.isEmpty();
    }

    boolean doProcessAndIfFail(char c) {
        if (c == '(') {
            open(c);
            return false;
        }

        return close();
    }

    void open(char c) {
        stack.push(c);
    }

    boolean close() {
        if (stack.isEmpty()) {
            return true;
        } else {
            stack.pop();
            return false;
        }
    }
}
