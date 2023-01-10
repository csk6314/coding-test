package programmers.level2;

import java.util.Arrays;

public class nSquareArrayCutting {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4,7,14)));
    }
    public static int[] solution(int n, long left, long right) {
        int gap = (int) (right-left)+1;
        int[] answer = new int[gap];
        long realIndex = left;
        for(int i =0;i<answer.length;i++,realIndex++) {
            long row_l = realIndex/n;
            long col_l = realIndex%n;
            int row = (int) row_l;
            int col = (int) col_l;
            if(row >= col) {
                answer[i] = row+1;
                continue;
            }
            if(row < col) {
                answer[i] = col+1;
                continue;
            }


        }
        return answer;
    }
}
