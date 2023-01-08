package programmers.level2;

import java.util.Arrays;

public class mpMatrix {
    public static void main(String[] args) {
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};
        System.out.println(Arrays.toString(solution(arr1,arr2)));
    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i=0;i<answer.length;i++) {
            for(int j =0;j<answer[0].length;j++) {
                int sum = 0;
                for(int k = 0;k<arr2.length;k++) {
                    sum+= arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
