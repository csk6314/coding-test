package programmers.level2;

import java.util.Arrays;

public class hIndex {
    public static void main(String[] args) {
        int[] citations = {3,0,1,5,6};
        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {

        int answer = 0;

        Arrays.sort(citations);

        int max = -1;
        int size = citations.length;
        for(int i =0;i<size;i++) {
            max = Math.max(max,Math.min(citations[i],size-i));
        }
        answer = max;

        return answer;
    }
}
