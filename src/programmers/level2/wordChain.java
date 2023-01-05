package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class wordChain {
    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] ans = solution(2,words);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public static int[] solution(int n, String[] words) {
        Map<String,Character> wordMap = new HashMap<>();
        int round =0;
        int num = 0;
        for(int i =1;i<=words.length;i++) {
            String word = words[i-1];
            if(!wordMap.containsKey(words[i-1])) {
                if((i>1 && wordMap.get(words[i-2]) == word.charAt(0))||i==1) {
                    wordMap.put(word,word.charAt(word.length()-1));
                    continue;
                }
            }
            round = ((i-1)/n)+1;
            num = (i-((round-1)*n))%(n+1);
            break;
        }
        int[] answer = {num,round};
        return answer;
    }
}
