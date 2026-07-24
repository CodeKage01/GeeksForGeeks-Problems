class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        int[][] prefix = new int[n][n];
        
        // build prefix matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                prefix[i][j] = mat[i][j];
                if(i > 0){
                    prefix[i][j]+= prefix[i-1][j];
                }
                if(j > 0){
                    prefix[i][j]+= prefix[i][j-1];
                }
                if(i > 0 && j > 0){
                    prefix[i][j]-= prefix[i-1][j-1];
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        // check everu k*k submatrix
        for(int i=0;i<=n-k;i++){
            for(int j=0;j<=n-k;j++){
                int r = i+k-1;
                int c = j+k-1;
                
                int sum = prefix[r][c];
                if(i > 0){
                    sum-= prefix[i-1][c];
                }
                if(j > 0){
                    sum-= prefix[r][j-1];
                }
                if(i > 0 && j > 0){
                    sum+= prefix[i-1][j-1];
                }
                ans = Math.max(ans, sum);
            }
        }
        
        return ans;
    }
}
