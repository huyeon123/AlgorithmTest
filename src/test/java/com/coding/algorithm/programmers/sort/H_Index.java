package com.coding.algorithm.programmers.sort;

import java.util.*;

public class H_Index {
    /**
     *
     */
    public static void main(String[] args) {
        H_Index T = new H_Index();
        int[] citations = {8, 13, 21, 34, 55};
        System.out.print(T.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
