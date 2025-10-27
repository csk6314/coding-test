

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<N;i++) {
            input = br.readLine().split(" ");
            pq.offer(Integer.parseInt(input[0]));
        }

        int answer = 0;

        while(pq.size() > 1) {
            int a = pq.poll();
            int b= pq.poll();

            int sum = a+b;
            pq.offer(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}
