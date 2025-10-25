class Solution {
    public int minOperations(int[] arr) {
        double totalSum = 0;
        for(int num:arr) totalSum+= num;
        
        double target = totalSum/2.0;
        double curSum = totalSum;
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:arr){
            maxHeap.add((double)num);
        }
        
        int operations = 0;
        
        while(curSum > target){
            double largest = maxHeap.poll();
            double half = largest/2.0;
            curSum -= (largest-half);
            maxHeap.add(half);
            operations++;
        }
        
        return operations;
    }
}
