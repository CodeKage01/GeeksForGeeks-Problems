class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int product = 1;
        
        // If k is odd and largest element is 0
        // 0 is the max possible product
        if(arr[n-1] == 0 && (k & 1) == 1){
            return 0;
        }
        
        // If all the element are negative and k is odd
        // choose k largest elements
        if(arr[n-1] <= 0 && (k & 1) == 1){
            for(int i=n-1;i>=n-k;i--){
                product*= arr[i];
            }
            return product;
        }
        
        int left = 0;
        int right = n-1;
        
        // If k is odd, take the largest element first
        if((k & 1) == 1){
            product*= arr[right];
            right--;
            k--;
        }
        
        // Now k is even
        // We will select k/2 pairs
        k = k/2;
        
        for(int i=0;i<k;i++){
            int leftProd = arr[left]*arr[left+1];
            int rightProd = arr[right]*arr[right-1];
            
            if(leftProd > rightProd){
                product*= leftProd;
                left+= 2;
            }else{
                product*= rightProd;
                right-=2;
            }
        }
        
        return product;
    }
}
