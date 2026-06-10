class Solution {
    int count = 0;
    
    public int binarySearchable(int[] arr) {
        count = 0;
        solve(arr, 0, arr.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return count;
    }
    
    private void solve(int[] arr, int l, int r, int lowBound, int highBound){
        if(l > r) return;
        int mid = (l+r)/2;
        
        if(arr[mid] > lowBound && arr[mid] < highBound){
            count++;
        }
        
        solve(arr, l, mid-1, lowBound, Math.min(highBound, arr[mid]));
        solve(arr, mid+1, r, Math.max(lowBound, arr[mid]), highBound);
    }
};
