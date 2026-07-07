class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];
        
        // Station P (Top row)
        for(int j=0;j<m;j++){
            dfs(0, j, mat, p);
        }
        // Station P (Left column)
        for(int i=0;i<n;i++){
            dfs(i, 0, mat, p);
        }
        
        // Station Q (bottom row)
        for(int j=0;j<m;j++){
            dfs(n-1, j, mat, q);
        }
        //Station Q (Right column)
        for(int i=0;i<n;i++){
            dfs(i, m-1, mat, q);
        }
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(p[i][j] && q[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int r, int c, int[][] mat, boolean[][] vis){
        if(vis[r][c]){
            return;
        }
        vis[r][c] = true;
        int n = mat.length;
        int m = mat[0].length;
        
        for(int k=0;k<4;k++){
            int nr = r+dr[k];
            int nc = c+dc[k];
            
            if(nr <0 || nc <0 || nr >= n || nc >= m){
                continue;
            }
            
            if(!vis[nr][nc] && mat[nr][nc] >= mat[r][c]){
                dfs(nr, nc, mat, vis);
            }
        }
    }
    
}
