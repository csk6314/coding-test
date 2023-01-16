package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class stock {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution(prices)));
    }
    static class priceTime {
        int time,price;
        public priceTime(int price, int time) {
            this.time = time;
            this.price = price;
        }
    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<priceTime> stack = new Stack<>();
        for(int i =0;i<prices.length;i++){
            if(!stack.isEmpty() && stack.peek().price > prices[i]) {
                while(!stack.isEmpty() && stack.peek().price > prices[i]) {
                    priceTime pt = stack.pop();
                    answer[pt.time] = i-pt.time;
                }
            }
            stack.push(new priceTime(prices[i],i));
        }
        int lastTime = prices.length-1;
        while(!stack.isEmpty()) {
            priceTime pt = stack.pop();
            answer[pt.time] = lastTime-pt.time;

        }

        return answer;

    }
}
