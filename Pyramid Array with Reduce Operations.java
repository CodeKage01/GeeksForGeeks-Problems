class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        
        for(int i=1;i<n;i++){
            left[i] = Math.min(arr[i], left[i-1] + 1);
        }
        
        right[n-1] = 1;
        
        for(int i=n-2;i>=0;i--){
            right[i] = Math.min(arr[i], right[i+1] + 1);
        }
        
        long totalSum = 0;
        long maxSum = 0;
        
        for(int i=0;i<n;i++){
            totalSum+= arr[i];
            
            int peak = Math.min(left[i], right[i]);
            
            long pyramidSum = 1L*peak*peak;
            
            maxSum = Math.max(maxSum, pyramidSum);
        }
        
        return (int)(totalSum - maxSum);
    }
};
