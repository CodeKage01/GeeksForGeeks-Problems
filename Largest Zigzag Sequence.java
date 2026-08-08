class Solution {
    int[][] dp;
    
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        int ans = 0;
        
        dp = new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        
        for(int col=0;col<n;col++){
            ans = Math.max(ans, solve(0, col, mat, n));
        }
        return ans;
    }
    
    private int solve(int row, int col, int[][] mat, int n){
        if(row == n-1){
            return mat[row][col];
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int best = 0;
        
        for(int nextCol = 0;nextCol<n;nextCol++){
            if(nextCol != col){
                best = Math.max(best, solve(row+1, nextCol, mat, n));
            }
        }
        return dp[row][col] = mat[row][col] + best;
    }
}
