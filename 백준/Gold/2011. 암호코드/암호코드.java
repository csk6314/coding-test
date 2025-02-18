import java.util.*;
import java.io.*;

public class Main {
	static final int MOD = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String code = br.readLine();
		int[] codeNum = new int[code.length() + 1];

		for (int i = 1; i < codeNum.length; i++) {
			codeNum[i] = code.charAt(i - 1) - '0';
		}
		
	//	System.out.println(Arrays.toString(codeNum));

		int[] dp = new int[codeNum.length];

		if (code.length() < 1 || codeNum[1] == 0) {
			System.out.println(0);
			return;
		}

		dp[0] = 1;
		dp[1] = 1;
		
		boolean isAbnormal = false;
		for (int i = 2; i < dp.length; i++) {
			boolean FLAG = false;
			
			if (isAlphaNum(codeNum[i])) {
				dp[i] += dp[i - 1];
				FLAG = true;
			}
			if (codeNum[i-1] != 0 && isAlphaNum(codeNum[i - 1] * 10 + codeNum[i])) {
				dp[i] += dp[i - 2];
				FLAG = true;
			}
			
			if(!FLAG) {
				isAbnormal = true;
				break;
			}
			dp[i] %= MOD;
		}
		
		if(isAbnormal) {
			System.out.println(0);
			return;
		}
		
		//System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[dp.length-1]);
		
		

	}

	public static boolean isAlphaNum(int v) {
		if (v < 10) {
			return (v > 0 && v < 10);
		}
		return (v >= 10 && v <= 26);
	}

}
