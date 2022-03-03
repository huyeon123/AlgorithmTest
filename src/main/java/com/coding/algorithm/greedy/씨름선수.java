package com.coding.algorithm.greedy;

import java.sql.SQLOutput;
import java.util.*;

public class 씨름선수 {
    /**
     * 설명
     * <p>
     * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
     * <p>
     * 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
     * <p>
     * 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
     * <p>
     * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
     * <p>
     * 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
     * <p>
     * N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
     * <p>
     * 두 번째 줄부터 N명의 키와 몸무게가 주어집니다.
     * <p>
     * 출력
     * 첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력하세요.
     * <p>
     * 예시 입력 1
     * 5
     * 172 67
     * 183 65
     * 180 70
     * 170 72
     * 181 60
     * <p>
     * 예시 출력 1
     * 3
     */
    public static class Person implements Comparable<Person> {
        public int height, weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Person(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);
        System.out.print(solution(list));
    }

    private static int solution(ArrayList<Person> list) {
        int answer = 0, max = Integer.MIN_VALUE;
        for (Person person : list) {
            if (person.weight > max) {
                max = person.weight;
                answer++;
            }
        }
        return answer;
    }

}
