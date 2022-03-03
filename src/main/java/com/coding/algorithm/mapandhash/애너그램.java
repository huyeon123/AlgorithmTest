package com.coding.algorithm.mapandhash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 애너그램 {
    /**
     * 설명
     * <p>
     * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
     * <p>
     * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
     * <p>
     * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
     * <p>
     * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
     * <p>
     * <p>
     * 입력
     * 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
     * <p>
     * 단어의 길이는 100을 넘지 않습니다.
     * <p>
     * <p>
     * 출력
     * 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
     * <p>
     * <p>
     * 예시 입력 1
     * AbaAeCe
     * baeeACA
     * <p>
     * 예시 출력 1
     * YES
     * <p>
     * 예시 입력 2
     * abaCC
     * Caaab
     * <p>
     * 예시 출력 2
     * NO
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();

        System.out.print(solution(str1, str2));
    }

    private static String solution(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char x : str1.toCharArray()) map1.put(x, map1.getOrDefault(x, 0) + 1);
        for (char x : str2.toCharArray()) map2.put(x, map2.getOrDefault(x, 0) + 1);
        if (map1.entrySet().equals(map2.entrySet())) return "YES";
        return "NO";
    }

}
