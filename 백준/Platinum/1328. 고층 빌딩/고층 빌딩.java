import java.io.*;

public class Main {
	static final int MOD =  1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int R = Integer.parseInt(input[2]);
		
		long[][][] dp = new long[N+1][N+1][N+1];
		
		dp[1][1][1] = 1;
        for(int i = 2;i<N+1;i++) {
			for(int l = 1;l<N+1;l++) {
				for(int r =1;r<N+1;r++) {
					dp[i][l][r] += dp[i-1][l][r] * (i-2);
					dp[i][l][r] += dp[i-1][l-1][r];
					dp[i][l][r] += dp[i-1][l][r-1];	
					dp[i][l][r] %= MOD;
					
					if(r>1 && dp[i][l][r] == 0) break; 
				}
			}
		}
		
		System.out.println(dp[N][L][R]);
		
	}
}
