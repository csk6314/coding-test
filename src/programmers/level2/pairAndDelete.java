package programmers.level2;

import java.util.Stack;

public class pairAndDelete {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                continue;
            }
            stack.push(ch);

        }
        if (stack.isEmpty()) return 1;
        return 0;
    }

}
