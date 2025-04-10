

import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String balls = br.readLine();
		
		int bCount = 0;
		int rCount = 0;
		int f_bCount = 0;
		int f_rCount = 0;
		
		int ans = Integer.MAX_VALUE;
		boolean FLAG = false;
		
		for(int i = balls.length()-1;i>=0;i--) {
			char ch = balls.charAt(i);
			
			if(ch=='R' && FLAG) {
				rCount ++;
			}
			
			if(ch=='B') {
				FLAG = true;
			}
		}
		
		FLAG = false;
		for(int i = balls.length()-1;i>=0;i--) {
			char ch = balls.charAt(i);
			
			if(ch=='B' && FLAG) {
				bCount ++;
			}
			
			if(ch=='R') {
				FLAG = true;
			}
		}
		
		ans = Math.min(rCount, bCount);
		
		FLAG = false;
		
		for(int i = 0;i < balls.length();i++) {
			char ch = balls.charAt(i);
			
			if(ch=='R' && FLAG) {
				f_rCount ++;
			}
			
			if(ch=='B') {
				FLAG = true;
			}
		}
		
		FLAG = false;
		
		for(int i = 0;i < balls.length();i++) {
			char ch = balls.charAt(i);
			
			if(ch=='B' && FLAG) {
				f_bCount ++;
			}
			
			if(ch=='R') {
				FLAG = true;
			}
		}
		
		ans = Math.min(ans, Math.min(f_rCount, f_bCount));
		
		System.out.println(ans);
	}
}
