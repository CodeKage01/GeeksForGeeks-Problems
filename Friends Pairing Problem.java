class Solution {
    int[] dp;
    
    public int countFriendsPairings(int n) {
        dp = new int[n+1];
        return solve(n);
    }
    
    private int solve(int n){
        if(n <= 2){
            return n;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int single = solve(n-1);
        int pair = (n-1)*solve(n-2);
        
        return dp[n] = (single + pair);
    }
}
