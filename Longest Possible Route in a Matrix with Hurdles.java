class Solution {
    int n, m;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        n = mat.length;
        m = mat[0].length;
        
        if(mat[xs][ys] == 0 || mat[xd][yd] == 0){
            return -1;
        }
        visited = new boolean[n][m];
        return dfs(mat, xs, ys, xd, yd);
    }
    
    private int dfs(int[][] mat, int r, int c, int xd, int yd){
        if(r == xd && c == yd){
            return 0;
        }
        visited[r][c] = true;
        int maxLen = -1;
        
        for(int k=0;k<4;k++){
            int nr = r+dr[k];
            int nc = c+dc[k];
            
            if(isSafe(mat, nr, nc)){
                int path = dfs(mat, nr, nc, xd, yd);
                if(path != -1){
                    maxLen = Math.max(maxLen, path+1);
                }
            }
        }
        visited[r][c] = false;
        return maxLen;
    }
    
    private boolean isSafe(int[][] mat, int r, int c){
        return r>=0 && r<n && c>=0 && c<m && mat[r][c] == 1 && !visited[r][c];
    }
}
