package programmers.level2;

public class VisitLength {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    static boolean[][] xCheck = new boolean[10][11];
    static boolean[][] yCheck = new boolean[11][10];
    static int nx = 5;
    static int ny = 5;

    public static int solution(String dirs) {
        int answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            if (dir == 'U') {
                ny++;
                answer += checkLine(0);
                continue;
            }
            if (dir == 'D') {
                ny--;
                answer += checkLine(1);
                continue;
            }
            if (dir == 'R') {
                nx++;
                answer += checkLine(2);
                continue;
            }
            if (dir == 'L') {
                nx--;
                answer += checkLine(3);
                continue;
            }

        }
        return answer;
    }

    static int checkLine(int dir) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        if (!canGo(nx, ny)) {
            nx += dx[dir];
            ny += dy[dir];
            return 0;
        }
        if (dir < 2) {
            if (!yCheck[nx][ny + (-1 + dir)]) {
                yCheck[nx][ny + (-1 + dir)] = true;
                return 1;
            }
            return 0;
        }
        if (!xCheck[nx + (-3 + dir)][ny]) {
            xCheck[nx + (-3 + dir)][ny] = true;
            return 1;
        }
        return 0;

    }

    static boolean canGo(int nx, int ny) {
        if (ny > 10 || ny < 0 || nx < 0 || nx > 10) {
            return false;
        }
        return true;
    }
}

