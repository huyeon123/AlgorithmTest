package com.coding.algorithm.programmers.bruteforce;

import java.util.*;

public class 모의고사 {
    /**
     *
     */
    public static void main(String[] args) {
        모의고사 T = new 모의고사();
        int[] answers = {1,3,2,4,2};

        for (int i : T.solution(answers)) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1 = 0, count2 = 0, count3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) count1++;
            if (answers[i] == student2[i % student2.length]) count2++;
            if (answers[i] == student3[i % student3.length]) count3++;
        }
        int max = Math.max(count1, Math.max(count2, count3));
        List<Integer> answer = new ArrayList<>();
        if(count1 == max) answer.add(1);
        if(count2 == max) answer.add(2);
        if(count3 == max) answer.add(3);
        Collections.sort(answer);

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
