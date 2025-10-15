
import java.io.*;
import java.util.*;

public class Main {
    // 3월 1일 = 60, 11월 30일 = 334
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final int START_DATE = 60;
    static final int END_DATE = 335;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //days 누적 합
        for (int i = 2; i <= 12; i++) {
            days[i] += days[i - 1];
        }

        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int m1 = Integer.parseInt(input[0]);
            int d1 = Integer.parseInt(input[1]);
            int m2 = Integer.parseInt(input[2]);
            int d2 = Integer.parseInt(input[3]);

            int start = days[m1 - 1] + d1;
            int end = days[m2 - 1] + d2;

            if (start < START_DATE) {
                start = START_DATE;
            }

            if (end > END_DATE) {
                end = END_DATE;
            }

            flowers[i] = new int[]{start, end};
        }

        Arrays.sort(flowers, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return (b[1] - b[0]) - (a[1] - a[0]);
                }
                return a[0] - b[0];
            }
        });

//        for(int i = 0;i<N;i++) {
//            for(int j = 0;j<2;j++) {
//                System.out.print(flowers[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(flowers[0][0] > START_DATE) {
            System.out.println(0);
            return;
        }

        int ans = 0, idx = 0, max = 0, e= 0;
        boolean FLAG = false;
        while (idx < N) {
            ans++;
            int[] flower = flowers[max];
            int init = max;

            if(flower[1] == END_DATE) {
                break;
            }

            while(idx+1 < N &&  flowers[idx+1][0] <= flower[1]) {
                if(flowers[idx+1][0] == flower[0] || flowers[idx+1][1] < flower[1]) {
                    idx++;
                    continue;
                }

                if(e < flowers[idx+1][1]) {
                    e = flowers[idx+1][1];
                    max = idx+1;
                }

                idx++;
            }
         //   System.out.println(e);

            if(init == max) {
                FLAG = true;
                break;
            }

        }

        if(FLAG) {
            System.out.println(0);
            return;
        }


        System.out.println(ans);

    }
}
