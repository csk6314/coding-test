
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] courses = new int[K][2];

        for(int i = 0;i<K;i++) {
            input = br.readLine().split(" ");

            int I = Integer.parseInt(input[0]);
            int T = Integer.parseInt(input[1]);

            courses[i] = new int[]{I, T};
        }

        int[] dp = new int[N+1];

        for(int i = 0;i<K;i++) {
            int v = courses[i][0];
            int t = courses[i][1];

            for(int j = N;j-t>=0;j--) {
                dp[j] = Math.max(dp[j-t] + v, dp[j]);
            }
        }

        System.out.println(dp[N]);




    }
}
