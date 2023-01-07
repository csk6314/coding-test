package programmers.level2;

public class jumpFarAway {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static long solution(int n) {
        long answer = 0;
        int[] DP = new int[2001];
        DP[1] = 1;
        DP[2] = 2;
        if (n == 1) return DP[1];
        if (n == 2) return DP[2];
        int idx = 3;
        while (idx <= n) {
            DP[idx] = (DP[idx - 1] + DP[idx - 2]) % 1234567;
            idx++;
        }
        answer = DP[idx - 1];
        return answer;
    }

}
