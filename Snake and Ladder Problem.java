class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int total = n*n;
        
        int[] jump = new int[total+1];
        
        for(int i=0;i<lad.length;i+=2){
            jump[lad[i]] = lad[i+1];
        }
        for(int i=0;i<sn.length;i+=2){
            jump[sn[i]] = sn[i+1];
        }
        
        boolean[] visited = new boolean[total+1];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{1, 0});
        visited[1] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cell = cur[0];
            int throwCount = cur[1];
            
            if(cell == total){
                return throwCount;
            }
            
            for(int dice=1;dice<=6;dice++){
                int next = cell + dice;
                if(next > total){
                    continue;
                }
                
                if(jump[next] != 0){
                    next = jump[next];
                }
                
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, throwCount + 1});
                }
            }
        }
        return -1;
    }
}
