

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] houseWeight = new int[N][3];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int g = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);

			houseWeight[i] = new int[] { r, g, b };
		}

		int[][] dp = new int[N][3];
	
		int ans = Integer.MAX_VALUE;
		
		for(int start =0;start<3;start++) {
			for(int i = 0;i<3;i++) {
				if(start != i) {
					dp[0][i] = 0; 
					continue;
				}
				dp[0][i] = houseWeight[0][i];
				dp[1][i] = 0;
			}
			
			for (int i = 1; i < N; i++) {
				for(int k =0 ;k<3;k++) {
					int v1 = dp[i-1][(k+1)%3];
					int v2 = dp[i-1][(k+2)%3];
					if(v1 ==0 && v2==0) continue;
					if(v1==0 && v2 > 0) {
						dp[i][k] = v2 + houseWeight[i][k];
						continue;
					}
					
					if(v2==0 && v1 > 0) {
						dp[i][k] = v1 + houseWeight[i][k];
						continue;
					}
				
					dp[i][k] = Math.min(v2, v1) + houseWeight[i][k];
				}
			}
			
//			for(int i = 0;i<N;i++) {
//				System.out.println(Arrays.toString(dp[i]));
//			}
			
			for(int i = 0;i<3;i++) {
				if(start!=i) {
					ans = Math.min(ans, dp[N-1][i]);
				}
			}
			
		}
		System.out.println(ans);
		
	
		
	}
}
