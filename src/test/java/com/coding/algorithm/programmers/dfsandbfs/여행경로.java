package com.coding.algorithm.programmers.dfsandbfs;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 여행경로 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        String[] test = new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
        Assertions.assertArrayEquals(test, solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
        Assertions.assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"},
                solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        Assertions.assertArrayEquals(new String[]{"ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"},
                solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}));
        Assertions.assertArrayEquals(new String[]{"ICN", "BOO", "ICN", "AOO"},
                solution(new String[][]{{"ICN", "AOO"}, {"ICN", "BOO"}, {"BOO", "ICN"}}));
        Assertions.assertArrayEquals(new String[]{"ICN", "SFO", "ICN", "SFO", "QRE"},
                solution(new String[][]{{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}}));
    }

    List<AirPort> list;
    String[] answer;
    boolean[] check;
    int count = 0;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        answer = new String[tickets.length + 1];
        check = new boolean[tickets.length];
        for (String[] ticket : tickets) {
            list.add(new AirPort(ticket[0], ticket[1]));
        }
        Collections.sort(list);

        for (AirPort airPort : list) {
            if (airPort.departure.equals("ICN")) {
                count = 0;
                Arrays.fill(answer, null);
                Arrays.fill(check, false);
                answer[count++] = "ICN";
                check[list.indexOf(airPort)] = true;
                DFS(airPort);
                if (answer[answer.length - 1] != null) break;
            }
        }
        return answer;
    }

    public void DFS(AirPort airPort) {
        int temp = count;
        answer[count] = airPort.arrival;
        boolean find = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).departure.equals(airPort.arrival)) {
                if (!check[i]) {
                    check[i] = true;
                    find = true;
                    count++;
                    DFS(list.get(i));
                    if (temp == count){
                        check[i] = false;
                        find = false;
                    }
                }
            }
            if (answer[answer.length - 1] != null) return;
        }
        if (!find) count--;
    }

    public class AirPort implements Comparable<AirPort> {
        public String departure, arrival;

        public AirPort(String departure, String arrival) {
            this.departure = departure;
            this.arrival = arrival;
        }

        @Override
        public int compareTo(AirPort o) {
            if (this.arrival.equals(o.arrival)) return this.departure.compareTo(o.departure);
            return this.arrival.compareTo(o.arrival);
        }
    }
}
