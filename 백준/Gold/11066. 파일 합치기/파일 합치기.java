

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			int[][] dp = new int[K + 1][K + 1];
			int[] sum = new int[K+1];
			
			for(int i = 1;i<K+1;i++) {
				for(int j = 1;j<K+1;j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			String[] inputs = br.readLine().split(" ");
			for (int i = 1; i <= K; i++) {
				sum[i] = sum[i-1] + Integer.parseInt(inputs[i-1]);
				dp[i][i] = 0;
			}
			
			for(int i = 1;i<K;i++) {
				for(int j = 1;j<=K-i;j++) {
					for(int k = 0;k<i;k++) {
						dp[j][j+i] = Math.min(dp[j][j+i], dp[j][j+k] + dp[j+k+1][j+i] + sum[j+i] -sum[j-1] );
					}
				} 
			}
			
//			for(int i = 0;i<=K;i++) {
//				System.out.println(Arrays.toString(dp[i]));
//			}
			
			System.out.println(dp[1][K]);
		}
	}
}
