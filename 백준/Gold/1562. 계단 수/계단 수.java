

import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][10][1024];

		for (int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int len = 1; len < N; len++) {
			for (int cur = 0; cur < 10; cur++) {
				for(int v= 0;v<1024;v++) {
					int current = dp[len][cur][v];
;					if(cur + 1 < 10) {
						//System.out.println(len + " " + cur + " " + v + " " + current);
						dp[len+1][cur+1][v | (1 << cur+1)] += current;
						dp[len+1][cur+1][v | (1 << cur+1)] %= 1000000000;
					}
					if(cur - 1 >= 0) {
						dp[len+1][cur-1][v | (1 << cur-1)] += current;
						dp[len+1][cur-1][v | (1 << cur-1)] %= 1000000000;
					}
				}
			}
		}
		
		int ans = 0;
		
		for(int n = 0;n<10;n++) {
		//	System.out.println(n + " " + dp[N][n][1023]);
			ans += dp[N][n][1023];
			ans %= 1000000000;
		}
		
		System.out.println(ans);
	}

}
