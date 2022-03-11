package com.coding.algorithm.programmers.heap;

import java.util.*;

public class 디스크_컨트롤러 {
    /**
     *
     */
    public static void main(String[] args) {
        디스크_컨트롤러 T = new 디스크_컨트롤러();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.print(T.solution(jobs));
    }

    public int solution(int[][] jobs) {
        int answer = 0, endTime = 0;

        PriorityQueue<Job> jobList = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) { return o1.inputTime - o2.inputTime; }
        });

        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) { return o1.processTime - o2.processTime; }
        });

        for (int[] job : jobs) jobList.add(new Job(job[0], job[1]));

        while (!jobList.isEmpty() || !pq.isEmpty()) {
            while (!jobList.isEmpty() && jobList.peek().inputTime <= endTime) {
                pq.add(jobList.poll());
            }
            if (!pq.isEmpty()) {
                endTime += pq.peek().processTime;
                answer += endTime - pq.poll().inputTime;
            } else {
                endTime++;
            }
        }

        return answer / jobs.length;
    }

    public class Job{
        public int inputTime, processTime;

        public Job(int inputTime, int processTime) {
            this.inputTime = inputTime;
            this.processTime = processTime;
        }
    }


}
