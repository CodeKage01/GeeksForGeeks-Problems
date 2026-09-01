class Solution {
    static final long mod = 1000000007L;
    
    public int palindromicStrings(int n, int k) {
        // length 1
        long ans = k;
        long ways = 1;
        
        for(int m=1;2*m<=n;m++){
            ways = ways*(k-m+1)%mod;
            long evenWays = ways;
            
            ans = (ans + evenWays) % mod;
            
            if(2*m + 1 <= n){
                long oddWays = ways*(k-m) % mod;
                ans = (ans + oddWays)%mod;
            }
        }
        return (int)ans;
    }
}
