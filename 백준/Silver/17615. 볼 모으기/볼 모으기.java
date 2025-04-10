

import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String balls = br.readLine();
		
		int bCount = 0;
		int rCount = 0;
		
		int rCnt = 0;
		int bCnt = 0;
		
		for(int i = 0;i<balls.length();i++) {
			char ch = balls.charAt(i);
			
			if(ch=='R') {
				rCnt ++;
				bCount += bCnt;
				bCnt = 0;
			}
			
			if(ch=='B') {
				bCnt++;
				rCount += rCnt;
				rCnt = 0;
			}
		}
		
		System.out.println(Math.min(rCount, bCount));
	}
}
