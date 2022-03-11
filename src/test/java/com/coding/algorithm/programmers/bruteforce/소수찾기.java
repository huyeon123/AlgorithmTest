package com.coding.algorithm.programmers.bruteforce;

import java.util.*;

public class 소수찾기 {
    /**
     *
     */
    static int answer = 0;
    static boolean[] check = new boolean[10];
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        소수찾기 T = new 소수찾기();
        String numbers = "17";
        String numbers2 = "011";

        System.out.print(T.solution(numbers2));
    }

    public int solution(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            DFS("", i + 1, numbers);
        }
        for (Integer integer : list) {
            isPrime(integer);
        }
        return answer;
    }

    public void DFS(String temp, int m, String numbers) {
        if (temp.length() == m) {
            int target = Integer.parseInt(temp);
            if(!list.contains(target)) list.add(target);
        } else {
            for (int i = 0; i < numbers.length(); i++) {
                if (!check[i]) {
                    check[i] = true;
                    temp += numbers.charAt(i);
                    DFS(temp, m, numbers);
                    check[i] = false;
                    temp = temp.substring(0, temp.length() - 1);
                }
            }
        }
    }

    private static void isPrime(int num) {
        if(num < 2) return;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return;
        }
        answer++;
    }

}
