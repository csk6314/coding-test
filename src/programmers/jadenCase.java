package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jadenCase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
    static String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        if(s.charAt(0) == ' ') isFirst=false;
        for(int j =0;j<s.length();j++) {
            char ch = s.charAt(j);
            if ( isFirst && ch != ' ' ) {
                isFirst=false;
                sb.append(Character.toUpperCase(ch));
                continue;
            }
            if(ch == ' ') {
                isFirst = true;
                sb.append(ch);
                continue;
            }
            sb.append(Character.toLowerCase(ch));
        }
        answer = sb.toString();
        return answer;
    }
}
