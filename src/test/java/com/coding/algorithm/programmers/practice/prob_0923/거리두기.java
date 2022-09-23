package com.coding.algorithm.programmers.practice.prob_0923;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 거리두기 {
    int[][] table;

    @Test
    void run() {
        assertArrayEquals(new int[]{1, 0, 1, 1, 1},
                solution(new String[][]{
                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                })
        );
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        for (String[] place : places) {
            table = mapToTable(place);
            int result = checkAll();
            answer[idx++] = result;
        }
        return answer;
    }

    private int[][] mapToTable(String[] place) {
        int[][] table = new int[5][5];
        for (int i = 0; i < place.length; i++) {
            char[] chars = place[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'P') {
                    table[i][j] = 1;
                    continue;
                }

                if (chars[j] == 'X') {
                    table[i][j] = -1;
                }
            }
        }
        return table;
    }

    private int checkAll() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] != 1) continue;
                if (isViolate(i, j)) return 0;
            }
        }

        return 1;
    }

    private boolean isViolate(int x, int y) {
        if (violateOneDistance(x, y)) return true;
        return violateTwoDistance(x, y);
    }

    private boolean violateOneDistance(int x, int y) {
        if (y > 0) {
            if (table[x][y - 1] == 1) return true;
        }

        if (x > 0) {
            if (table[x - 1][y] == 1) return true;
        }

        if (y < 4) {
            if (table[x][y + 1] == 1) return true;
        }

        if (x < 4) {
            if (table[x + 1][y] == 1) return true;
        }

        return false;
    }

    private boolean violateTwoDistance(int x, int y) {
        if (y > 1) {
            if (table[x][y - 2] == 1) {
                if (table[x][y - 1] != -1) return true;
            }
        }

        if (x > 0 && y > 0) {
            if (table[x - 1][y - 1] == 1) {
                if (table[x][y - 1] != -1 || table[x - 1][y] != -1) return true;
            }
        }

        if (x > 2) {
            if (table[x - 2][y] == 1) {
                if (table[x - 1][y] != -1) return true;
            }
        }

        if (x > 0 && y < 4) {
            if (table[x - 1][y + 1] == 1) {
                if (table[x - 1][y] != -1 || table[x][y + 1] != -1) return true;
            }
        }

        if (y < 3) {
            if (table[x][y + 2] == 1) {
                if (table[x][y + 1] != -1) return true;
            }
        }

        if (x < 4 && y < 4) {
            if (table[x + 1][y + 1] == 1) {
                if (table[x][y + 1] != -1 || table[x + 1][y] != -1) return true;
            }
        }

        if (x < 3) {
            if (table[x + 2][y] == 1) {
                if (table[x + 1][y] != -1) return true;
            }
        }

        if (x < 4 && y > 0) {
            if (table[x + 1][y - 1] == 1) {
                if (table[x + 1][y] != -1 || table[x][y - 1] != -1) return true;
            }
        }

        return false;
    }


}
