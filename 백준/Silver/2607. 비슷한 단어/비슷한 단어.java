

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] charMap = new int[26];
		
		int N = Integer.parseInt(br.readLine());
		
		String firstWord = br.readLine();
		
		for(int i = 0;i<firstWord.length();i++) {
			charMap[firstWord.charAt(i) - 'A']++;
		}
		
		int ans = 0;
		
		for(int i = 1;i<N;i++) {
			String word = br.readLine();
			int[] wordCharMap = new int[26];
			
			for(int j = 0;j<word.length();j++) {
				wordCharMap[word.charAt(j) - 'A']++;
			}
			
			int fMore = 0;
			int wMore = 0;
			
			for(int j=0;j<26;j++) {
				if(wordCharMap[j] > charMap[j]) {
					wMore += wordCharMap[j] - charMap[j];
					continue;
				}
				if(charMap[j] > wordCharMap[j]) {
					fMore += charMap[j] - wordCharMap[j];
					continue;
				}
			}
		//	System.out.println(fMore + " " + wMore);
			
			if(fMore == 0 && wMore == 0) {
				ans++;
				continue;
			}
			
			if(fMore + wMore == 1) {
				ans++;
				continue;
			}
			
			if(fMore ==1 && wMore == 1) {
				ans++;
				continue;
			}
			
		}
		System.out.println(ans);
		
	}
}
