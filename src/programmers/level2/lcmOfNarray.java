package programmers.level2;

public class lcmOfNarray {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(solution(arr));
    }
        public static int solution(int[] arr) {
            int answer = 0;
            for(int i =0;i<arr.length-1;i++) {
                int arr_gcd = gcd(arr[i],arr[i+1]);
                arr[i+1] = arr[i] * arr[i+1] / arr_gcd;
            }
            answer = arr[arr.length-1];
            return answer;
        }
        static int gcd(int a,int b) {
            while(b!=0) {
                int r = a%b;
                a = b;
                b=r;
            }
            return a;
        }
}
