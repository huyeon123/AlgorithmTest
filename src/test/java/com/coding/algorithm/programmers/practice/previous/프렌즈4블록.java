package com.coding.algorithm.programmers.practice.previous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 프렌즈4블록 {

    int n, m, answer = 0;
    char[][] charBoard;
    boolean[][] remove;

    @Test
    void test_1(){
        solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }

    public int solution(int m, int n, String[] board) {
        init(m, n, board);

        process();

        return answer;
    }

    private void init(int m, int n, String[] board) {
        this.n = n;
        this.m = m;
        remove = new boolean[m][n];
        charBoard = new char[m][n];

        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                charBoard[i][j] = chars[j];
            }
        }
    }

    private void process() {
        allCheck();

        int removed = remove();

        answer += removed;

        if (removed != 0) {
            process();
        }
    }

    private void allCheck() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(i, j);
            }
        }
    }

    private void check(int x, int y) {
        if (x == m - 1 || y == n - 1) {
            return;
        }

        if (charBoard[x][y] == '\0') {
            return;
        }

        Set<Character> target = new HashSet<>();
        target.add(charBoard[x][y]);
        target.add(charBoard[x][y + 1]);
        target.add(charBoard[x + 1][y]);
        target.add(charBoard[x + 1][y + 1]);

        if (target.size() == 1) {
            remove[x][y] = true;
            remove[x][y + 1] = true;
            remove[x + 1][y] = true;
            remove[x + 1][y + 1] = true;
        }
    }

    private int remove() {
        char[][] newBoard = new char[m][n];
        int[] idx = new int[n];
        Arrays.fill(idx, m - 1);
        int removed = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (!remove[i][j]) {
                    newBoard[idx[j]--][j] = charBoard[i][j];
                } else removed++;
            }
        }

        charBoard = newBoard;
        remove = new boolean[m][n];
        return removed;
    }
}
