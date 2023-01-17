package programmers.level2;

import java.util.HashSet;

public class subSequenceSum {
    public static void main(String[] args) {
        int[] seq = {7,9,1,1,4};
        System.out.println(solution(seq));
    }
    static HashSet<Integer> answerSet = new HashSet<>();
    public static int solution(int[] elements) {
        return getSequenceSum(elements);
    }
    public static int getSequenceSum(int[] elements) {
        for(int i = 0;i < elements.length;i++) {
            getSubSequenceSum(elements, i);
        }
        return answerSet.size();
    }
    public static void getSubSequenceSum(int[] elements, int start) {
        int cnt = 0;
        int sum = 0;
        while(cnt < elements.length) {
            if(start >= elements.length) {
                start = 0;
            }
            sum += elements[start++];
            cnt++;
            answerSet.add(sum);
        }
    }
}
