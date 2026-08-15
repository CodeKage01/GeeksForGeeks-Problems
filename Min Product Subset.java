class Solution {
    public int minProd(int[] arr) {
        int product = 1;
        int negativeCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        int minPositive = Integer.MAX_VALUE;
        boolean hasZero = false;
        
        for(int x:arr){
            if(x == 0){
                hasZero = true;
                continue;
            }
            product*= x;
            
            if(x < 0){
                negativeCount++;
                maxNegative = Math.max(maxNegative, x);
            }else{
                minPositive = Math.min(minPositive, x);
            }
        }
        
        if(negativeCount == 0){
            if(hasZero){
                return 0;
            }
            return minPositive;
        }
        if(negativeCount % 2 == 0){
            product/= maxNegative;
        }
        return product;
    }
}
