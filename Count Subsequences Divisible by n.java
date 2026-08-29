class Solution {
    public int countSubsequences(String s, int n) {
        long mod = 1_000_000_007;
        
        long[] dp = new long[n];
        for(char c:s.toCharArray()){
            int curDigit = c-'0';
            
            long[] newDp = dp.clone();
            
            int rem = curDigit % n;
            newDp[rem] = (newDp[rem] + 1) % mod;
            
            for(int r=0;r<n;r++){
                int newRem = (r * 10 + curDigit) % n;
                newDp[newRem] = (newDp[newRem] + dp[r]) % mod;
            }
            dp = newDp;
        }
        return (int)dp[0];
    }
}

