class Solution {
    static class Cell{
        int row;
        int col;
        int dist;
        
        Cell(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] unsafe = new boolean[n][m];
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    unsafe[i][j] = true;
                    
                    for(int d=0;d<4;d++){
                        int nr = i+dr[d];
                        int nc = j+dc[d];
                        
                        if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                            unsafe[nr][nc] = true;
                        }
                    }
                }
            }
        }
        
        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            if(!unsafe[i][0]){
                q.offer(new Cell(i, 0, 1));
                visited[i][0] = true;
            }
        }
        
        
        while(!q.isEmpty()){
            Cell cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int dist = cur.dist;
            
            if(col == m - 1){
                return dist;
            }
            
            for(int d=0;d<4;d++){
                int nr = row + dr[d];
                int nc = col + dc[d];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !unsafe[nr][nc] && 
                !visited[nr][nc]){
                    q.offer(new Cell(nr, nc, dist + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}
