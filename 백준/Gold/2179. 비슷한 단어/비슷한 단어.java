import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String,Integer> dict = new HashMap<>();
		ArrayList<String> words = new ArrayList<>();
		
		int cnt = N;
		int max = 0;
		int[] ans = {0,1};
		while(cnt-- > 0) {
			String word = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0;i<word.length();i++) {
				sb.append(word.charAt(i));
				String tmp  = sb.toString();
				if(dict.containsKey(tmp)) {
                    if(max == i+1 && ans[0] > dict.get(tmp)) {
						ans[0] = dict.get(tmp);
						ans[1] = N-(cnt+1);
						continue;
					}
					if(max < i+1) {
						max = i+1;
						ans[0] = dict.get(tmp);
						ans[1] = N-(cnt+1);

						
					}
					continue;
				}
				dict.put(tmp, N-(cnt+1));
			}
			
			words.add(sb.toString());
			
		}
		
		System.out.println(words.get(ans[0]));
		System.out.println(words.get(ans[1]));
		

		
		
	}
}
