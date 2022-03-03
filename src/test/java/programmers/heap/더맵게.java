package programmers.heap;

import java.util.*;

public class 더맵게 {
    /**
     *
     */
    public static void main(String[] args) {
        더맵게 T = new 더맵게();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.print(T.solution(scoville, k));
    }

    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) pq.add(i);
        while (pq.size() > 1 && pq.peek() < k) {
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        if (pq.size() == 1 && pq.peek() < k) return -1;
        return answer;
    }

}
