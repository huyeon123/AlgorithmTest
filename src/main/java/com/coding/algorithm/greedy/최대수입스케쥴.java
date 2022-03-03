package com.coding.algorithm.greedy;

import java.util.*;

public class 최대수입스케쥴 {
    /**
     * 설명
     * <p>
     * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
     * <p>
     * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
     * <p>
     * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
     * <p>
     * <p>
     * 입력
     * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
     * <p>
     * <p>
     * 출력
     * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
     * <p>
     * <p>
     * 예시 입력 1
     * 6
     * 50 2
     * 20 1
     * 40 2
     * 60 3
     * 30 3
     * 30 1
     * <p>
     * 예시 출력 1
     * 150
     */


    public static class Lecture implements Comparable<Lecture>{
        int money, deadLine;

        public Lecture(int money, int deadLine) {
            this.money = money;
            this.deadLine = deadLine;
        }

        @Override
        public int compareTo(Lecture o) {
            if(o.deadLine == this.deadLine) return o.money - this.money;
            return o.deadLine - this.deadLine;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        ArrayList<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int time = sc.nextInt();
            list.add(new Lecture(money, time));
            if(time > max) max = time;
        }
        Collections.sort(list);
        System.out.print(solution(list, max));
    }

    private static int solution(ArrayList<Lecture> list, int max) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = max; i >= 1; i--) {
            while(!list.isEmpty()) {
                Lecture lecture = list.get(0);
                if (lecture.deadLine == i) {
                    queue.add(lecture.money);
                    list.remove(0);
                }
                else break;
            }
            if(!queue.isEmpty()) answer += queue.poll();
        }
        return answer;
    }

}
