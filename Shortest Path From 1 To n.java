// Iterative Approach
class Solution {
    public int minimumStep(int n) {
        int steps = 0;
        
        while(n > 1){
            if(n % 3 == 0){
                n = n / 3;
            }else{
                n = n-1;
            }
            steps++;
        }
        return steps;
    }
}



// Recursive Approach
class Solution {
    public int minimumStep(int n) {
        if(n == 1){
            return 0;
        }
        
        if(n % 3 == 0){
            return 1 + minimumStep(n / 3);
        }else{
            return 1 + minimumStep(n - 1);
        }
    }
}
