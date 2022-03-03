package com.coding.algorithm.programmers.greedy;

import java.util.*;

public class 조이스틱 {
    /**
     *
     */
    public static void main(String[] args) {
        조이스틱 T  = new 조이스틱();
        String name = "BBBAAAAAAB";
        System.out.print(T.solution(name));
    }

    public int solution(String name) {
        int answer = 0, ps = 0, left = name.length() - 1, right = 0, move = 0;
        ArrayList<Integer> notA = new ArrayList<>();
        for (int i = 0; i < name.toCharArray().length; i++) if (name.toCharArray()[i] != 'A') notA.add(i);

        for (Integer integer : notA) {
            answer += Math.min(name.charAt(integer) - 'A', 'Z' - name.charAt(integer) + 1);
            right = integer;
            left = Math.min(left, name.length() - integer + 2 * ps);
            left = Math.min(left, (name.length() - integer) * 2 + ps);
            ps = integer;
        }
        move = Math.min(left, right);
        return answer + move;
    }

}
