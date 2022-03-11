package com.coding.algorithm.programmers.greedy;

import java.util.Arrays;

public class 체육복 {
    /**
     *
     */
    public static void main(String[] args) {
        체육복 T = new 체육복();
        int n = 15;
        int[] lost = {1, 5, 8, 9};
        int[] reserve = {1, 4, 7, 10};
        System.out.print(T.solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for (int i : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if ((i - 1 == reserve[j]) || (i + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
