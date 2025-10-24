

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);

        int[] trucks = new int[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(input[i]);
        }

        int curWeight = 0;
        int[] bridge = new int[w];
        int time = 0;
        int truckIdx = 0;
        int passed = 0;

        while (passed < n) {

            // 다리에 트럭이 있으면 한 칸씩 이동
            for (int i = w - 1; i >= 0; i--) {
                if (bridge[i] > 0) {
                    if(i==w-1) {
                        curWeight -= trucks[bridge[i] - 1];
                        bridge[i] = 0;
                        passed ++;
                        continue;
                    }

                    bridge[i + 1] = bridge[i];
                    bridge[i] = 0;
                }
            }

            // 다리 무게가 낮으면 트럭 추가
            if (truckIdx < n && curWeight + trucks[truckIdx] <= L) {
                bridge[0] = truckIdx + 1;
                curWeight += trucks[truckIdx];
                truckIdx++;
            }

            time++;
          //  System.out.println(time + " , " + passed);

        }

        System.out.println(time);
    }
}
