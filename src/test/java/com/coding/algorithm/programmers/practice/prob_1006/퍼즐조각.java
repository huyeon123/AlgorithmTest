package com.coding.algorithm.programmers.practice.prob_1006;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 퍼즐조각 {
    List<int[][]> blanks = new ArrayList<>();
    List<int[][]> puzzles = new ArrayList<>();
    int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상, 우, 하, 좌
    int[][] gameBoard, gTable;
    int size, answer = 0;


    @Test
    void test() {
        assertEquals(0, solution(
                new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}},
                new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}}
        ));
    }

    public int solution(int[][] game_board, int[][] table) {
        gameBoard = game_board;
        gTable = table;
        size = game_board.length;

        getPiece();

        checkPiece();

        return answer;
    }

    //BFS 순회 조각 판별
    private void getPiece() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //gameBoard는 빈칸
                if (gameBoard[i][j] == 0) blanks.add(BFS(i, j, gameBoard, 0));
                //table은 조각
                if (gTable[i][j] == 1) puzzles.add(BFS(i, j, gTable, 1));
            }
        }
    }

    private int[][] BFS(int i, int j, int[][] targetArr, int target) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        list.add(new int[]{i, j});
        queue.add(new int[]{i, j});
        targetArr[i][j] = -1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] move : moves) {
                int mx = cur[0] + move[0];
                int my = cur[1] + move[1];

                if (mx < 0 || mx >= size || my < 0 || my >= size) continue;

                if (targetArr[mx][my] == target) {
                    queue.add(new int[]{mx, my});
                    list.add(new int[]{mx, my});
                    targetArr[mx][my] = -1;
                }
            }
        }

        return getCoordinate(list);
    }

    //list에서 최대 x, y 좌표를 구해서 배열을 만듦
    private int[][] getCoordinate(List<int[]> list) {
        int maxX = 0, maxY = 0, minX = size, minY = size;
        for (int[] ints : list) {
            maxX = Math.max(maxX, ints[0]);
            maxY = Math.max(maxY, ints[1]);
            minX = Math.min(minX, ints[0]);
            minY = Math.min(minY, ints[1]);
        }

        int size = Math.max(maxX - minX, maxY - minY) + 1;
        int[][] coordinate = new int[size][size];
        for (int[] ints : list) {
            int x = ints[0] - minX;
            int y = ints[1] - minY;
            coordinate[x][y] = 1;
        }
        return coordinate;
    }

    private void checkPiece() {
        boolean[] isCovered = new boolean[blanks.size()];

        for (int[][] puzzle : puzzles) {
            int puzzleCount = getCellCount(puzzle);
            int puzzleLength = puzzle.length;

            //puzzle을 한개씩 가져와서 blank 후보에다가 하나씩 다 넣어봄
            for (int[][] blank : blanks) {
                int index = blanks.indexOf(blank);
                if (isCovered[index]) continue; //덮였으면 할필요없음

                int blankLength = blank.length;
                if (puzzleLength != blankLength) continue; //사이즈가 다르면 할필요 없음

                int blankCount = getCellCount(blank);
                if (puzzleCount != blankCount) continue; //puzzle 칸과 blank 칸 갯수가 다르면 할필요없음

                boolean match = false;
                for (int rotate = 0; rotate < 4; rotate++) {
                    //맞는지 확인
                    if (match(puzzle, blank)) {
                        //맞으면 isCovered에 표시, answer 증가
                        isCovered[index] = true;
                        match = true;
                        answer += puzzleCount;
                        break;
                    }
                    //안맞으면 회전
                    puzzle = rotatePiece(puzzle);
                }
                if (match) {
                    break;
                }
            }
        }
    }

    private int getCellCount(int[][] piece) {
        int count = 0;
        for (int[] ints : piece) {
            for (int j = 0; j < piece.length; j++) {
                if (ints[j] == 1) count++;
            }
        }

        return count;
    }

    private boolean match(int[][] puzzle, int[][] blank) {
        int size = puzzle.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzle[i][j] != blank[i][j]) return false;
            }
        }
        return true;
    }

    private int[][] rotatePiece(int[][] piece) {
        List<int[]> list = new ArrayList<>();

        int size = piece.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (piece[i][j] == 1) {
                    list.add(new int[]{j, size - i - 1});
                }
            }
        }

        return getCoordinate(list);
    }
}
