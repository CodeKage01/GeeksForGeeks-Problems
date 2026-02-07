class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        
        int i=0,j=0,k=0;
        
        int bestDif = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;
        
        int[] ans = new int[3];
        
        while(i<a.length && j<b.length && k<c.length){
            int x=a[i];
            int y=b[j];
            int z=c[k];
            
            int maxVal = Math.max(x, Math.max(y,z));
            int minVal = Math.min(x, Math.min(y,z));
            
            int dif = maxVal-minVal;
            int sum = x+y+z;
            
            if(dif < bestDif || (dif == bestDif && sum < bestSum)){
                bestDif = dif;
                bestSum = sum;
                
                ans[0] = x;
                ans[1] = y;
                ans[2] = z;
            }
            
            if(minVal == x){
                i++;
            }else if(minVal == y){
                j++;
            }else{
                k++;
            }
        }
        Arrays.sort(ans);
        return new int[]{ans[2], ans[1], ans[0]};
    }
}
