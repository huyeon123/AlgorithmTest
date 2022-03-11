package programmers.dynamic;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class 도둑질 {
    @DisplayName("테스트 케이스")
    @Test
    public void testCase() {
        Assertions.assertEquals(4, solution(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(10, solution(new int[]{3, 1, 1, 6, 1, 1, 1}));
        Assertions.assertEquals(6, solution(new int[]{3, 2, 1, 2, 1, 2}));
        Assertions.assertEquals(9, solution(new int[]{3, 1, 3, 5, 3, 2}));
        Assertions.assertEquals(19, solution(new int[]{3, 1, 5, 6, 3, 1, 1, 5, 6, 3, 1}));
    }

    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];

        dp[0][0] = money[0];
        dp[0][1] = money[0];
        dp[1][1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
        }

        return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
    }

}
