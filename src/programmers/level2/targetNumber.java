package programmers.level2;

public class targetNumber {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        System.out.println(solution(numbers,3));
    }
    static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers,target,0,0);
        return answer;
    }

    static int dfs(int[] numbers, int target, int idx, int value) {
        if(idx == numbers.length) {
            if(value==target) return 1;
            return 0;
        }
        int v = numbers[idx];
        int ans = dfs(numbers,target,idx+1,value+v) + dfs(numbers,target,idx+1,value+v*(-1));
        return ans;
    }
}
