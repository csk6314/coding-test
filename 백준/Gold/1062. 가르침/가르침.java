
import java.io.*;
import java.util.Arrays;

public class Main{
	static boolean[] usedChar = new boolean[26];
	static int[] charSet;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		
		charSet = new int[N];
		
		if(K < 5) {
			System.out.println(0);
			System.exit(0);
		}
		
		usedChar['a' - 'a'] = true;
		usedChar['i' - 'a'] = true;
		usedChar['t' - 'a'] = true;
		usedChar['n' - 'a'] = true;
		usedChar['c' - 'a'] = true;
		K-=5;
		
		for(int i = 0;i<N;i++) {
			String word = br.readLine();
			boolean[] alpha = new boolean[26];
			int k = 0;
			for(int j = 0;j<word.length();j++) {
				alpha[word.charAt(j) - 'a'] = true;
				k = (k | 1 << (word.charAt(j) - 'a'));
			}
			
			//System.out.println(Integer.toBinaryString(k));
			
			charSet[i] = k;
		}
		
		
		
		combination(26,K,-1);
		System.out.println(ans);
		
	}
	
	public static void combination(int n, int r,int k) {
		if(r == 0) {
			int b = 0;
			for(int i = 0;i<26;i++) {
				if(usedChar[i]) {
					b = (b | 1 << i);
				}
			}
			
			int cnt = 0;
			
			for(int i = 0;i<charSet.length;i++) {
				//System.out.println(Integer.toBinaryString(b));
				//System.out.println(Integer.toBinaryString(charSet[i]));
				//System.out.println(Integer.toBinaryString(charSet[i] | b));
				if((charSet[i]|b)  == b) {
					cnt++;
				}
			}
			
			ans = Math.max(ans, cnt);
			return;
		}
		
		for(int i = k+1;i<n;i++) {
			if(usedChar[i]) continue;
			usedChar[i] = true;
			combination(n,r-1,i);
			usedChar[i] = false;
		}
	}
}
