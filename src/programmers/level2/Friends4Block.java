package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Friends4Block {
    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(6,6,board));
    }


    static List<Point> deleteList = new ArrayList<>();

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] cBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            cBoard[i] = board[i].toCharArray();
        }

        //탐색
        while (search(cBoard, m, n)) {
            deleteBlock(cBoard);
            for (int i = 0; i < n; i++) {
                for (int j = m - 2; j >= 0; j--) {
                    removeBlank(cBoard, i, j);
                }
            }
        }

        answer = getBlankNum(cBoard, m, n);


        return answer;
    }

    public static boolean search(char[][] board, int m, int n) {
        boolean flag = false;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (judgeSame(board, i, j)) {
                    flag = true;
                    deleteList.add(new Point(j, i));
                }
            }
        }
        return flag;
    }

    public static boolean judgeSame(char[][] board, int y, int x) {
        char[] block = new char[4];
        block[0] = board[y][x];
        block[1] = board[y][x + 1];
        block[2] = board[y + 1][x];
        block[3] = board[y + 1][x + 1];

        for (int i = 0; i < block.length - 1; i++) {
            if (block[i] == '0') return false;
            if (block[i] != block[i + 1]) {
                return false;
            }
        }

        return true;

    }

    public static void deleteBlock(char[][] board) {
        while (!deleteList.isEmpty()) {
            Point p = deleteList.remove(0);
            int x = p.x;
            int y = p.y;
            board[y][x] = '0';
            board[y][x + 1] = '0';
            board[y + 1][x] = '0';
            board[y + 1][x + 1] = '0';
        }
    }

    public static void removeBlank(char[][] board, int x, int y) {
        if (board[y][x] == '0') return;
        if (board[y + 1][x] != '0') return;
        int idx = y;
        while (idx + 1 < board.length && board[idx + 1][x] == '0') {
            idx++;
        }
        board[idx][x] = board[y][x];
        board[y][x] = '0';
        return;
    }

    public static int getBlankNum(char[][] board, int m, int n) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print(board[i][j]);
                if (board[i][j] == '0') cnt++;
            }
            //System.out.println("");
        }
        return cnt;
    }

}
