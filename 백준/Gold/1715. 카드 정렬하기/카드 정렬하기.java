import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cardQueue = new PriorityQueue<>();
        for (int i =0;i<N;i++) {
            cardQueue.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        
        while(cardQueue.size() >= 2) {
            int a = cardQueue.poll();
            int b = cardQueue.poll();
            int c = a+b;
            sum += c;
            cardQueue.offer(c);
        }

        System.out.println(sum);

    }
}