class Solution {
    int[][] dp;
    int n, m;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longIncPath(int[][] matrix, int n, int m) {
        this.n = n;
        this.m = m;
        
        dp = new int[n][m];
        
        int ans = 0;
        
        // try every cell as starting point
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int r, int c){
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        
        int best = 1;
        for(int[] dir:directions){
            int nr = r+dir[0];
            int nc = c+dir[1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                if(matrix[nr][nc] > matrix[r][c]){
                    best = Math.max(best, 1+dfs(matrix, nr, nc));
                }
            }
        }
        dp[r][c] = best;
        return best;
    }
}
