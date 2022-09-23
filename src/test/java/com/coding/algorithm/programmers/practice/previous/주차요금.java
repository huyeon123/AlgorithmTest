package com.coding.algorithm.programmers.practice.previous;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 주차요금 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertArrayEquals(new int[]{14600, 34400, 5000}, solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                        "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                        "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
//        Assertions.assertArrayEquals(0, solution());
    }

    HashMap<String, InAndOut> table = new HashMap<>();
    HashMap<String, Double> answerTable = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) { //입출차 테이블 작성
            String[] token = record.split(" ");
            String[] timeStr = token[0].split(":");
            double time = Double.parseDouble(timeStr[0]) * 60 + Double.parseDouble(timeStr[1]);

            if (token[2].equals("IN")) table.put(token[1], new InAndOut(time, 1439d));
            else {
                table.get(token[1]).out = time;
                writeTable(token[1]);
            }
        }

        for (String carNumber : table.keySet()) {
            if (!table.get(carNumber).check){
                writeTable(carNumber);
            }
        }

        //차량번호 작은 순으로 요금 출력
        List<String> keyList = new ArrayList<>(table.keySet());
        Collections.sort(keyList);
        int[] answer = new int[keyList.size()];
        int idx = 0;
        for (String carNumber : keyList) {
            int cost = fees[1];
            double time = answerTable.get(carNumber);
            if (time > fees[0]) cost += Math.ceil((time - fees[0]) / fees[2]) * fees[3];
            answer[idx++] = cost;
        }

        return answer;
    }

    public void writeTable(String carNumber) {
        double overTime = table.get(carNumber).out - table.get(carNumber).in;
        table.get(carNumber).check = true;
        answerTable.put(carNumber, answerTable.getOrDefault(carNumber, 0d) + overTime);
    }

    public class InAndOut {
        double in;
        double out;
        boolean check;

        public InAndOut(double in, double out) {
            this.in = in;
            this.out = out;
            this.check = false;
        }
    }

}
