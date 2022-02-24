package com.coding.algorithm.programmers;

import java.util.LinkedList;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        다리를_지나는_트럭 T = new 다리를_지나는_트럭();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(T.solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, sum = 0;
        LinkedList<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) bridge.add(0);
        for (int i = 0; i < truck_weights.length; ) {
            if (!bridge.isEmpty()) sum -= bridge.poll();
            if (weight >= sum + truck_weights[i]) {
                bridge.add(truck_weights[i]);
                sum += truck_weights[i];
                i++;
            } else bridge.add(0);
            answer++;
        }
        while (!bridge.isEmpty()) {
            bridge.poll();
            answer++;
        }
        return answer;
    }
}
