package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class correctParse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push('(');
                continue;
            }
            if (stack.isEmpty()) {
                answer = false;
                break;
            }
            if (ch == ')') {
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }

}
