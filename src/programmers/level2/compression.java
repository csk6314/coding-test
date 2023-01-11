package programmers.level2;

import java.util.*;

public class compression {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
    }
    public static int[] solution(String msg) {
        Map<String,Integer> dict = new HashMap<String,Integer>();
        List<Integer> ansList = new ArrayList<>();
        for(int i=0;i<26;i++) {
            dict.put(String.valueOf((char)(65+i)),i+1);
        }
        int dictIndex=26;


        for(int i =0;i<msg.length();) {
            StringBuilder sbWord = new StringBuilder();
            sbWord.append(msg.charAt(i));
            int idx = i;
            boolean flag=false;
            while(dict.containsKey(sbWord.toString()) && idx<msg.length()) {
                if(idx==msg.length()-1) {
                    flag = true;
                    break;
                }
                idx++;
                sbWord.append(msg.charAt(idx));
            }

            if(!flag) {
                dict.put(sbWord.toString(),++dictIndex);
                sbWord.deleteCharAt(sbWord.length()-1);
            }
            if(flag) idx++;

            ansList.add(dict.get(sbWord.toString()));
            i=idx;

        }


        int[] answer = new int[ansList.size()];
        for(int i =0;i<answer.length;i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}
