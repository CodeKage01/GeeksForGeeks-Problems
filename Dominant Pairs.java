class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int half = n / 2;
        
        Arrays.sort(arr, 0, half);
        Arrays.sort(arr, half, n);
        
        int j = half;
        int count = 0;
        
        for(int i=0;i<half;i++){
            while(j < n && 5L*arr[j] <= arr[i]){
                j++;
            }
            count+= j - half;
        }
        return count;
    }
}
