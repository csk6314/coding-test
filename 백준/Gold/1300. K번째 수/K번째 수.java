import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int N, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(binarySearch());
    }

    static public long binarySearch() {
        long low = 1;
        long high = (long) N*N;
        long mid = 0;

        while(low <= high) {
            mid = (low+high) / 2;
//            System.out.println(low + " , " + high);
//            System.out.println(count(mid));
            if(count(mid) >= k) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    static public long count(long n) {
        long sum = 0;
        for(long i = 1;i<=N;i++) {
            if(N*i < n) {
                sum+=N;
                continue;
            }
            sum += n/i;
        }

        return sum;
    }
}
