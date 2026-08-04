class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        long ans = countLessEqual(arr, r) - countLessEqual(arr, l-1);
        return (int)ans;
    }
    
    private long countLessEqual(int[] arr, int limit){
        if(limit < 0){
            return 0;
        }
        int l = 0;
        long count = 0;
        long sum = 0;
        
        for(int r=0;r<arr.length;r++){
            sum+= arr[r];
            while(sum > limit){
                sum-=arr[l];
                l++;
            }
            count+= (r - l + 1);
        }
        return count;
    }
}
