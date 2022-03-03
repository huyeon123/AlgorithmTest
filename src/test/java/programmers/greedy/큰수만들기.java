package programmers.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class 큰수만들기 {
    /**
     *
     */
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.print(solution(number, k));
    }

    private static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
