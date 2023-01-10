package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class newsClustering {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE","FRENCH"));
    }
    static class Pair {
        int s1,s2;
        public Pair(int s1, int s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public void plusS1() {
            this.s1++;
        }
        public void plusS2() {
            this.s2++;
        }
    }
    public static int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Pair> map = new HashMap<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i =0;i<str1.length()-1;i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            String sbstr = String.valueOf(c1) + String.valueOf(c2);
            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                if(!map.containsKey(sbstr)){
                    map.put(sbstr,new Pair(1,0));
                    continue;
                }
                map.get(sbstr).plusS1();
            }
        }

        for(int i =0;i<str2.length()-1;i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            String sbstr = String.valueOf(c1) + String.valueOf(c2);
            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                if(!map.containsKey(sbstr)){
                    map.put(sbstr,new Pair(0,1));
                    continue;
                }
                map.get(sbstr).plusS2();
            }
        }

        if(map.size()==0) {
            return 1*65536;
        }

        int union = 0;
        int intersection = 0;
        for(Map.Entry<String,Pair> entry : map.entrySet()) {
            Pair p = entry.getValue();
            if(p.s1 == 0) {
                union+=p.s2;
                continue;
            }
            if(p.s2 == 0) {
                union += p.s1;
                continue;
            }
            union += Math.max(p.s1,p.s2);
            intersection += Math.min(p.s1,p.s2);
        }
        answer = (int) (((double) intersection/ (double) union) * 65536);
        return answer;
    }
}
