class Solution {
    int[][] memo;
    
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        memo = new int[n][2];
        for(int[] m:memo){
            Arrays.fill(m ,-1);
        }
        return solve(0, false, h, l);
    }
    
    private int solve(int i, boolean prevTask, int[] h, int[] l){
        if(i == h.length){
            return 0;
        }
         int state = prevTask ? 1 : 0;
         
         if(memo[i][state] != -1){
             return memo[i][state];
         }
        
        // do nothing
        int skip = solve(i+1, false, h, l);
        // low effort task
        int low = l[i] + solve(i+1, true, h, l);
        // high effort task
        
        int high = 0;
        if(!prevTask){
            high = h[i] + solve(i+1, true, h, l);
        }
        
        return memo[i][state] = Math.max(skip, Math.max(low, high));
    }
}
