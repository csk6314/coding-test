package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class repeatBinaryTest {
    static int cnt_zero = 0;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] ans = solution(s);
        System.out.println("[ " + ans[0] + ", " + ans[1] + " ]" );
    }
    public static int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            s= convert(s);
        }
        answer[1] = cnt_zero;
        answer[0] = cnt;
        return answer;
    }
    static String convert(String s) {
        int size = s.length();
        int count  = 0;
        for(int i =0;i<size;i++) {
            char ch = s.charAt(i);
            if(ch=='0') {
                count++;
                continue;
            }
        }
        int cnt_one = size - count;
        cnt_zero += count;
        cnt++;
        return Integer.toBinaryString(cnt_one);
    }
}
