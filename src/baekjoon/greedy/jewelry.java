package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class jewelry {
    static class Jewelry implements Comparable<Jewelry>{
        int weight, price;
        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry o) {
            return this.weight-o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Jewelry[] j = new Jewelry[N];
        int[] bags = new int[K];
        PriorityQueue<Jewelry> jQueue = new PriorityQueue<>(new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o2.price-o1.price;
            }
        });

        for(int i=0;i<N;i++) {
            input = br.readLine().split(" ");
            j[i] = new Jewelry(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        for(int i=0;i<K;i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(j);
        int jIndex = 0;
        long sum = 0;
        for(int i =0;i<K;i++) {
            while(jIndex<N && bags[i] >= j[jIndex].weight) {
                jQueue.offer(j[jIndex]);
                jIndex++;
            }
            if(!jQueue.isEmpty()) {
                sum += jQueue.poll().price;
            }
        }
        System.out.println(sum);
    }
}
