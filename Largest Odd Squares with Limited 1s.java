class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] prefix = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int[] query:queries){
            int i = query[0];
            int j = query[1];
            
            int maxRadius = Math.min(
                Math.min(i, j),
                Math.min(n-1-i, m-1-j)
                );
                
            int low = 0, high = maxRadius;
            int best = -1;
            
            while(low <= high){
                int radius = low + (high-low)/2;
                int top = i-radius;
                int bottom = i+radius;
                int left = j-radius;
                int right = j+radius;
                
                int ones = prefix[bottom+1][right+1] - prefix[top][right+1] - prefix[bottom+1][left] 
                + prefix[top][left];
                
                if(ones <= k){
                    best = radius;
                    low = radius + 1;
                }else{
                    high = radius - 1;
                }
            }
            if(best == -1){
                ans.add(-1);
            }else{
                ans.add(2*best + 1);
            }
        }
        return ans;
    }
}
