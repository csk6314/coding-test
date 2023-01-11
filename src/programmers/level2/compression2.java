package programmers.level2;

import java.util.*;

public class compression2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
    }
    public static int[] solution(String msg) {
        Map<String,Integer> dict = new HashMap<>();
        List<Integer> ansList = new ArrayList<>();
        for(int i=0;i<26;i++) {
            dict.put(String.valueOf((char)(65+i)),i+1);
        }
        int dictIndex=26;
        int maxSizeWord = 1;
        for(int i =0;i<msg.length();) {
            int idx = Math.min(msg.length(),i + maxSizeWord);
            while(i<idx) {
                StringBuilder sbword = new StringBuilder(msg.substring(i,idx));
                String word = sbword.toString();
                //System.out.println(word);
                if(dict.containsKey(word)) {
                    ansList.add(dict.get(word));
                    i+=word.length();

                    if(i<msg.length()) {
                        sbword.append(msg.charAt(i));
                        maxSizeWord = Math.max(sbword.length(),maxSizeWord);
                        //System.out.println(sbword.toString());
                        dict.put(sbword.toString(),++dictIndex);
                    }
                }
                idx--;
            }
        }
        int[] answer = new int[ansList.size()];
        for(int i =0;i<answer.length;i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}
