package programmers.level2;

public class Hopscotch {
    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
        };
        System.out.println(solution(land));
    }

    static int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == j) {
                        continue;
                    }
                    max = Math.max(max, dp[i - 1][k]);
                }
                dp[i][j] = max + land[i][j];
            }
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }

}
