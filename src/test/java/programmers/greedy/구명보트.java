package com.coding.algorithm.programmers.greedy;

import java.util.Arrays;

public class 구명보트 {
    /**
     *
     */
    public static void main(String[] args) {
        int[] people = {40, 40, 40};
        int limit = 100;

        System.out.print(solution(people, limit));
    }

    private static int solution(int[] people, int limit) {
        int answer = 0, min = 0;
        Arrays.sort(people);
        for (int max = people.length - 1; min <= max; max--) {
            if(people[min] + people[max] <= limit) min++;
            answer++;
        }
        return answer;
    }

}
