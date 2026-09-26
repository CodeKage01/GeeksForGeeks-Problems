class Solution {
    int[] dp;
    
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        dp = new int[x+1];
        Arrays.fill(dp, -1);
        
        return solve(x, s, m, l, cs, cm, cl);
    }
    
    private int solve(int x, int s, int m, int l, int cs, int cm, int cl){
        if(x <= 0){
            return 0;
        }
        
        if(dp[x] != -1){
            return dp[x];
        }
        
        // option1
        int small = cs + solve(x-s, s, m, l, cs, cm, cl);
        // option2
        int medium = cm + solve(x-m, s, m, l, cs, cm, cl);
        // option3
        int large = cl + solve(x-l, s, m, l, cs, cm, cl);
        
        return dp[x] = Math.min(small, Math.min(medium, large));
    }
}
