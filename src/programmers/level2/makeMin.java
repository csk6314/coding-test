package programmers.level2;

import java.util.Arrays;

public class makeMin {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        System.out.println(solution(A,B));
    }
    public static int solution(int []A, int []B)
    {
        int answer = 0;
        int size = A.length;
        int a_start,a_end,b_start,b_end;

        a_start = 0;
        b_start = 0;
        a_end = size-1;
        b_end = size-1;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i =0;i<size;i++) {
            int temp1 = A[a_start] * B[b_end];
            int temp2 = A[a_end] * B[b_start];
            if (temp1 < temp2) {
                answer += temp1;
                a_start++;
                b_end--;
                continue;
            }
            if( temp1 >= temp2){
                answer += temp2;
                a_end--;
                b_start++;
                continue;
            }
        }
        return answer;
    }
}
