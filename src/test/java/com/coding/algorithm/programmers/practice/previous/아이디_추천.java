package com.coding.algorithm.programmers.practice.previous;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 아이디_추천 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
        Assertions.assertEquals("z--", solution("z-+.^."));
    }

    public String solution(String new_id) {
        new_id = new_id.toLowerCase(); //Step 1
        new_id = new_id.replaceAll("[^a-z0-9-_.]", ""); //Step 2
        new_id = new_id.replaceAll("[.]+", "."); //Step 3
        new_id = new_id.replaceAll("^[.]|[.]$", ""); //Step 4
        if(new_id.isBlank()) new_id = "a"; //Step 5
        else if(new_id.length() >= 16) { //Step 6
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith(".")) new_id = new_id.substring(0, 14);
        }
        if(new_id.length() <= 2){ //Step 7
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            String lastWord = String.valueOf(new_idBuilder.charAt(new_idBuilder.length() - 1));
            while (new_idBuilder.length() <= 2){
                new_idBuilder.append(lastWord);
            }
            new_id = new_idBuilder.toString();
        }
        return new_id;
    }

}
