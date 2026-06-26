class Solution {
    static final int mod = 1000000007;
    static int n, m;
    static Long[][] dp;
    
    public static int countWays(String s1, String s2) {
        
        n = s1.length();
        m = s2.length();
        
        dp = new Long[n+1][m+1];
        
        return (int)solve(0, 0, s1, s2);
    }
    
    static long solve(int i, int j, String s1, String s2){
        if(j == m){
            return 1;
        }
        if(i == n){
            return 0;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        long ans;
        if(s1.charAt(i) == s2.charAt(j)){
            long take = solve(i+1, j+1, s1, s2);
            long skip = solve(i+1, j, s1, s2);
            ans = (take + skip) % mod;
        }else{
            ans = solve(i+1, j, s1, s2) % mod;
        }
        return dp[i][j] = ans;
    }
}
