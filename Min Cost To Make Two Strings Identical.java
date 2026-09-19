class Solution {
    int[][] memo;
    
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int n = s1.length();
        int m = s2.length();
        
        memo = new int[n][m];
        
        for(int[] m1:memo){
            Arrays.fill(m1, -1);
        }
        
        return solve(s1, s2, n-1, m-1, costS1, costS2);
    }
    
    private int solve(String s1, String s2, int i, int j, int costS1, int costS2){
        if(i < 0){
            return (j+1)*costS2;
        }
        if(j < 0){
            return (i+1)*costS1;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return memo[i][j] = solve(s1, s2, i-1, j-1, costS1, costS2);
        }
        
        int deleteS1 = costS1 + solve(s1, s2, i-1, j, costS1, costS2);
        int deleteS2 = costS2 + solve(s1, s2, i, j-1, costS1, costS2);
        
        return memo[i][j] = Math.min(deleteS1, deleteS2);
    }
}
