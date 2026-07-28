// Sorting Approach

class Solution {
    int minSubsets(int arr[]) {
        Arrays.sort(arr);
        int count = 1;
        
        for(int i=1;i<arr.length;i++){
            if((arr[i] - arr[i-1]) != 1){
                count++;
            }
        }
        return count;
    }
}


// Hash Set Approach
class Solution {
    int minSubsets(int arr[]) {
        Set<Integer> s = new HashSet<>();
        for(int num:arr){
            s.add(num);
        }
        
        int count = 0;
        for(int x:arr){
            if(!s.contains(x-1)){
                count++;
            }
        }
        return count;
    }
}
