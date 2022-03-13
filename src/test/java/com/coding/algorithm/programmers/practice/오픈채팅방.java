package com.coding.algorithm.programmers.practice;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 오픈채팅방 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertArrayEquals(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."},
                solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}));
//        Assertions.assertEquals(0, solution());
    }

    public String[] solution(String[] records) {
        ArrayList<Record> message = new ArrayList<>();
        HashMap<String, String> table = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] command = records[i].split(" ");
            switch (command[0]) {
                case "Enter":
                    table.put(command[1], command[2]);
                    message.add(new Record(command[0], command[1], command[2]));
                    break;
                case "Leave":
                    String nickname = table.get(command[1]);
                    message.add(new Record(command[0], command[1], nickname));
                    break;
                case "Change":
                    table.put(command[1], command[2]);
                    break;
            }
        }

        String[] answer = new String[message.size()];
        for (int i = 0; i < message.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String uid = message.get(i).uid;
            switch (message.get(i).status) {
                case "Enter":
                    sb.append(table.get(uid)).append("님이 들어왔습니다.");
                    answer[i] = sb.toString();
                    break;
                case "Leave":
                    sb.append(table.get(uid)).append("님이 나갔습니다.");
                    answer[i] = sb.toString();
                    break;
            }
        }
        return answer;
    }

    public class Record {
        String status;
        String uid;
        String nickname;

        public Record(String status, String uid, String nickname) {
            this.status = status;
            this.uid = uid;
            this.nickname = nickname;
        }
    }


}
