class Solution {
    public int sameMod(int[] arr) {
        int g = 0;
        
        // find gcd
        for(int i=1;i<arr.length;i++){
            int dif = Math.abs(arr[i] - arr[0]);
            g = gcd(g, dif);
        }
        
        if(g == 0){
            return -1;
        }
        
        int count = 0;
        
        for(int i=1;i*i<=g;i++){
            if(g % i == 0){
                count+= 2;
                
                if(i*i == g){
                    count--;
                }
            }
        }
        
        return count;
    }
    
    private int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
