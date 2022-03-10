package programmers.dynamic;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 정수삼각형 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(30, solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
//        Assertions.assertEquals(0, solution());
    }

    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length];
        dp[0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            int[] temp = dp.clone();
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) temp[j] = dp[j] + triangle[i][j];
                else if (j == triangle[i].length - 1) temp[j] = dp[j - 1] + triangle[i][j];
                else {
                    temp[j] = Math.max(dp[j - 1], dp[j]) + triangle[i][j];
                }
            }
            dp = temp;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
