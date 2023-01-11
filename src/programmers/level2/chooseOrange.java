package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class chooseOrange {
    public static void main(String[] args) {
        int[] tangerine = {1,3,2,5,4,5,2,3};
        System.out.println(solution(6,tangerine));
    }
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t,map.getOrDefault(t,0)+1);
        }
        Integer[] nt = new Integer[map.size()];
        int idx = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            nt[idx++] = entry.getValue();
        }
        Arrays.sort(nt, Collections.reverseOrder());
        idx = 0;
        while(k > 0) {
            k-=nt[idx++];
            answer++;
        }
        return answer;
    }
}
