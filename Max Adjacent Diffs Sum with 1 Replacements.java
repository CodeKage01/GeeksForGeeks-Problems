class Solution {
    public int maxDiffSum(int[] arr) {
        int prevOriginal = 0;
        int prevOne = 0;
        
        for(int i=1;i<arr.length;i++){
            int prev = arr[i-1];
            int curr = arr[i];
            
            // keep current element as original
            int currentOriginal = Math.max(
                prevOriginal + Math.abs(curr - prev),
                prevOne + Math.abs(curr - 1)
                );
                
            // Replace current element with 1
            int currentOne = Math.max(
                prevOriginal + Math.abs(1 - prev),
                prevOne
                );
                
            // current becomes previous for next iteration
            prevOriginal = currentOriginal;
            prevOne = currentOne;
        }
        
        return Math.max(prevOriginal, prevOne);
    }
}
