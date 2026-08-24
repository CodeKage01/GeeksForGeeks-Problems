class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        
        int[] pos = new int[n+1];
        
        for(int i = 0; i<n;i++){
            pos[arr[i]] = i;
        }
        
        int maxLen = 1;
        int curLen = 1;
        
        for(int val = 2;val <= n;val++){
            if(pos[val] > pos[val-1]){
                curLen++;
            }else{
                curLen = 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        
        return n - maxLen;
    }
}
