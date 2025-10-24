import java.util.*;

class Solution {
    static boolean[] visited;
    static int size;
    static String dst;
    static String[] ws;
    
    static class Pair {
        String key;
        int cnt;
        
        public Pair(String key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        size = words.length;
        visited = new boolean[size];
        dst = target;
        ws = words;
        
        boolean noTargetInWords = true;
        
        for(int i = 0;i<size;i++) {
            if(words[i].equals(dst)) {
                noTargetInWords = false;
            }
        }
        
        if(noTargetInWords) return 0;
        
        
        answer = bfs(begin);
        
        return answer;
    }
    
    public int bfs(String begin) {
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(begin,0));
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
           // System.out.println(p.key + " , " + p.cnt);
            
            if(p.key.equals(dst)) {
                return p.cnt;
            }
            
            for(int i = 0;i<ws.length;i++) {
                int diff = getDiff(p.key, ws[i]);
                
                if(diff == 1 && !visited[i]) {
                    q.offer(new Pair(ws[i], p.cnt + 1));
                    visited[i] = true;
                }
            }
            
        }
        
        return 0;
    }
    
    public int getDiff(String a, String b) {
        int diff = 0;
        for(int i = 0;i<a.length();i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        
        return diff;
    }
}