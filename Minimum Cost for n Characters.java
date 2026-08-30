class Solution {
    public int minCost(int n, int i, int d, int c) {
        int[] dp = new int[n+1];
        
        dp[1] = i;
        
        for(int x=2;x<=n;x++){
            // option 1
            dp[x] = dp[x-1] + i;
            
            // option 2: copy-paste from floor(x/2)
            int k1 = x/2;
            int cost1 = dp[k1] + c;
            if(2*k1 < x){
                cost1+= (x-2*k1)*i;
            }else{
                cost1+= (2*k1-x)*d;
            }
            dp[x] = Math.min(dp[x], cost1);
            
            // option 3: copy pase from ceil(x/2)
            int k2 = (x+1)/2;
            int cost2 = dp[k2] + c;
            
            if(2*k2 < x){
                cost2+= (x-2*k2)*i;
            }else{
                cost2+= (2*k2-x)*d;
            }
            dp[x] = Math.min(dp[x], cost2);
        }
        
        return dp[n];
    }
}
