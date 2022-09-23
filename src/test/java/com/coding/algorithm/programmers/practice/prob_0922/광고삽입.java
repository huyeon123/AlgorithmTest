package com.coding.algorithm.programmers.practice.prob_0922;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 광고삽입 {
    int[] viewer;

    @Test
    void test_1() {
        Assertions.assertEquals(
                "01:30:59",
                solution("02:03:55", "00:14:15",
                        new String[]{
                                "01:20:15-01:45:14",
                                "00:40:31-01:00:00",
                                "00:25:50-00:48:29",
                                "01:30:59-01:53:29",
                                "01:37:44-02:02:30"
                        }
                )
        );
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = timeToSec(play_time);
        viewer = new int[playSec + 1];

        for (String log : logs) {
            StringTokenizer st = new StringTokenizer(log, "-");
            int startSec = timeToSec(st.nextToken());
            int endSec = timeToSec(st.nextToken());

            viewer[startSec]++;
            viewer[endSec]--;
        }

        for (int i = 1; i < viewer.length; i++) {
            viewer[i] += viewer[i - 1];
        }

        long cum = 0;
        List<Long> cumSum = new ArrayList<>();
        cumSum.add(0L);
        for (int j : viewer) {
            cum += j;
            cumSum.add(cum);
        }

        int advSec = timeToSec(adv_time);
        long max = 0, answer = 0;

        for (int i = 0; i < viewer.length; i++) {
            if (i + advSec >= cumSum.size()) break;

            long insertTime = cumSum.get(i + advSec) - cumSum.get(i);

            if (insertTime > max) {
                max = insertTime;
                answer = i;
            }
        }

        return timeFormatting(answer);
    }

    private int timeToSec(String timeFormat) {
        StringTokenizer st = new StringTokenizer(timeFormat, ":");
        int hour = Integer.parseInt(st.nextToken()) * 3600;
        int min = Integer.parseInt(st.nextToken()) * 60;
        int sec = Integer.parseInt(st.nextToken());
        return hour + min + sec;
    }

    private String timeFormatting(long time) {
        long hour = time / 3600;
        long min = (time % 3600) / 60;
        long sec = time % 60;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}
