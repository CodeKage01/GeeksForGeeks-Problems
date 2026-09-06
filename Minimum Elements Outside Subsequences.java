class Solution {
    int[][][] dp;
    int[] arr;
    int n;
    public int minCount(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        dp = new int[n][101][101];
        
        for(int[][] d:dp){
            for(int[] d1:d){
                Arrays.fill(d1, -1);
            }
        }
        
        int maxUsed = solve(0, 0, 0);
        return n - maxUsed;
    }
    
    private int solve(int index, int inc, int dec){
        if(index == n){
            return 0;
        }
        if(dp[index][inc][dec] != -1){
            return dp[index][inc][dec];
        }
        
        int x = arr[index];
        
        // 1. skip current element
        int ans = solve(index+1, inc, dec);
        
        // 2. put in increasing subsequence
        if(inc == 0 || x > inc){
            int putInInc = 1 + solve(index+1, x, dec);
            ans = Math.max(ans, putInInc);
        }
        
        // 3. put in decreasing subsequence
        if(dec == 0 || x < dec){
            int putInDec = 1 + solve(index+1, inc, x);
            ans = Math.max(ans, putInDec);
        }
        
        return dp[index][inc][dec] = ans;
    }
}
