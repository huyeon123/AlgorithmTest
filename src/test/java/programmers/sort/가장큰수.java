package programmers.sort;

import java.util.*;

public class 가장큰수 {
    /**
     *
     */
    public static void main(String[] args) {
        가장큰수 T = new 가장큰수();
        int[] numbers = {6, 10, 3};

        System.out.print(T.solution(numbers));
    }

    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)) //합쳐서 비교 후 내림차순 정렬
                .reduce("", (s1, s2) -> s1.equals("0") && s2.equals("0") ? "0" : s1.concat(s2));
    }


}
