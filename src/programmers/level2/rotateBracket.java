package programmers.level2;

import java.util.Hashtable;
import java.util.Stack;

public class rotateBracket {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        Hashtable<Character, Character> dict = new Hashtable<>();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');
        for (int i = 0; i < s.length(); i++) {

            int idx = i;
            int cnt = 0;

            while (cnt < s.length()) {
                if (idx >= s.length()) {
                    idx = 0;
                }
                char ch = s.charAt(idx);
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                    idx++;
                    cnt++;
                    continue;
                }
                if (stack.isEmpty()) {
                    stack.push('x');
                    break;
                }
                char ptChar = dict.get(ch);
                if (!stack.isEmpty() && stack.peek() != ptChar) {
                    break;
                }
                stack.pop();
                idx++;
                cnt++;
            }

            if (!stack.isEmpty()) {
                stack.clear();
                continue;
            }
            answer++;
        }
        return answer;

    }

}
