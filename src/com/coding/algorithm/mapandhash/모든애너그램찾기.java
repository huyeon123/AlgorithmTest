package com.coding.algorithm.mapandhash;

import java.util.*;

public class 모든애너그램찾기 {
    /**
     *설명
     * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
     * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
     *
     * 입력
     * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
     * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
     *
     * 출력
     * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
     *
     * 예시 입력 1
     * bacaAacba
     * abc
     *
     * 예시 출력 1
     * 3
     *
     * 힌트
     * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();

        System.out.print(solution(str1, str2));

    }

    private static int solution(String str, String str2) {
        int answer = 0, lt = 0, rt = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : str2.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);

        for (int i = 0; i < str2.length() - 1; i++) {
            map1.put(str.charAt(i), map1.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (rt = str2.length() - 1; rt < str.length(); rt++) {
            map1.put(str.charAt(rt), map1.getOrDefault(str.charAt(rt), 0) + 1);
            if(map1.equals(map2)) answer++;
            map1.put(str.charAt(lt), map1.get(str.charAt(lt)) - 1);
            if(map1.get(str.charAt(lt)) == 0) map1.remove(str.charAt(lt));
            lt++;
        }

        return answer;
    }

}
