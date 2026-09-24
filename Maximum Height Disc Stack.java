class Solution {
    int[] dp;
    
    class Disc{
        int radius;
        int height;
        Disc(int radius, int height){
            this.radius = radius;
            this.height = height;
        }
    }
    
    public int maxStackHeight(int[] r, int[] h) {
        dp = new int[1001];
        int n = r.length;
        
        Disc[] discs = new Disc[n];
        
        for(int i=0;i<n;i++){
            discs[i] = new Disc(r[i], h[i]);
        }
        
        Arrays.sort(discs, (a, b)->{
            if(a.radius != b.radius){
                return Integer.compare(a.radius, b.radius);
            }
            return Integer.compare(b.height, a.height);
        });
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            int height = discs[i].height;
            int best = dp[height-1];
            
            int current = best + height;
            updateDp(height, current);
            
            ans = Math.max(ans, current);
        }
        return ans;
    }
    
    private void updateDp(int index, int value){
        while(index < dp.length){
            dp[index] = Math.max(dp[index], value);
            index++;
        }
    }
}
