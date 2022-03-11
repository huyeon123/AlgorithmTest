package com.coding.algorithm.programmers.dynamic;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class N으로표현 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(4, solution(5, 12));
        Assertions.assertEquals(-1, solution(5, 31168));
        Assertions.assertEquals(1, solution(5, 5));
    }

    public int solution(int N, int number) {
        ArrayList<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) list.add(new HashSet<>());
        list.get(1).add(N);
        if (list.get(1).contains(number)) return 1;
        for (int i = 2; i < 9; i++) {
            Set<Integer> set = list.get(i);
            for(int j=1; j<=i; j++){
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i - j);
                for(int preNum : preSet){
                    for(int postNum : postSet){
                        set.add(preNum + postNum);
                        if(preNum - postNum > 0) set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        if(preNum != 0 && postNum != 0) set.add(preNum / postNum);
                    }
                }
            }
            set.add(Integer.valueOf(String.valueOf(N).repeat(i)));
            if (set.contains(number)) return i;
        }
        return -1;
    }

}
