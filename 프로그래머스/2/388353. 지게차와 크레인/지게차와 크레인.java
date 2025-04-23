import java.util.*;

class Solution {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        char[][] cStorage = new char[n][m];
        
        for(int i = 0;i<n;i++) {
            cStorage[i] = storage[i].toCharArray();
        }
        
        for(String req : requests) {
            if(req.length() == 2) {
                crayne(req.charAt(0),n,m,cStorage);
            } else {
                forkLift(req.charAt(0),n,m,cStorage);
            }
   
   
        }
        
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
              //  System.out.print(cStorage[i][j]);
                if(cStorage[i][j] != 'x') {
                    answer ++;
                }
            }
            //System.out.println();
        }
        
        return answer;
    }
    
    public void forkLift(char target,int n,int m,char[][] storage) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        ArrayList<int[]> posList = new ArrayList<>();
        
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                    visited[i][j] = true;
                    q.offer(new int[] {i,j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] p = q.poll();
            
            if(storage[p[0]][p[1]] == target) {
                posList.add(new int[]{p[0],p[1]});
                continue;
            }
            
            for(int i = 0;i<4;i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(visited[nr][nc]) continue;
                
                if(storage[p[0]][p[1]] == 'x' && (storage[nr][nc] == 'x' ||  storage[nr][nc] == target)) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                    continue;
                }
                
            }
            
        }
        
        for(int[] pos : posList) {
            storage[pos[0]][pos[1]] = 'x';
        }
    }
    
    public void crayne(char target,int n,int m,char[][] storage) {
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(storage[i][j] == target) {
                    storage[i][j] = 'x';
                }
            }
        }
    }
    
    
}