class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] reach = new int[26];
        
        Arrays.fill(reach, -1);
        
        int ans = -1;
        
        for(int i=n-1;i>=0;i--){
            int ch = s.charAt(i)-'a';
            int curReach;
            
            if(ch == 25){
                curReach = i;
            }else if(reach[ch+1] != -1){
                curReach = reach[ch+1];
            }else{
                curReach = i;
            }
            reach[ch] = Math.max(reach[ch], curReach);
            
            if(ch == 0){
                ans = Math.max(ans, curReach-i);
            }
        }
        return ans;
    }
}
