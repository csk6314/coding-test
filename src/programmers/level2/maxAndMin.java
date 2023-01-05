package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class maxAndMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
    static String solution(String s) {
        String answer = "";
        String[] s_values = s.split(" ");
        int size = s_values.length;
        int[] values = new int[size];
        for(int i =0;i<size;i++) {
            values[i] = Integer.parseInt(s_values[i]);
        }
        Arrays.sort(values);
        answer = values[0] + " " + values[size-1];
        return answer;
    }
}
