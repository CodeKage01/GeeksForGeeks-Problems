class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);
        
        return count(arr, r) - count(arr, l-1);
    }
    
    private int count(int[] arr, int x){
        int n = arr.length;
        int count = 0;
        
        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;
            
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum <= x){
                    count = count + (k-j);
                    j++;
                }else{
                    k--;
                }
            }
        }
        return count;
    }
}
