package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class meetingRoom {
    static class Room implements Comparable<Room> {
        int start, end;
        public Room(int start, int end) {
            this.start = start;
            this.end =end;
        }

        @Override
        public int compareTo(Room o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];
        for(int i =0;i<N;i++) {
            String[] input = br.readLine().split(" ");
            rooms[i] = new Room(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        Arrays.sort(rooms);
        int ans = 0;
        int lastTime = 0;
        for(int i =0;i<N;i++) {
            if(rooms[i].start >= lastTime) {
                    lastTime = rooms[i].end;
                    ans++;
            }
        }
        System.out.println(ans);
    }

}
