class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        // Left Maximum
        int currMax = arr[0];
        leftMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            leftMax[i] = Math.max(leftMax[i - 1], currMax);
        }

        // Left Minimum
        int currMin = arr[0];
        leftMin[0] = arr[0];

        for (int i = 1; i < n; i++) {
            currMin = Math.min(arr[i], currMin + arr[i]);
            leftMin[i] = Math.min(leftMin[i - 1], currMin);
        }

        // Right Maximum
        currMax = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            rightMax[i] = Math.max(rightMax[i + 1], currMax);
        }

        // Right Minimum
        currMin = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            currMin = Math.min(arr[i], currMin + arr[i]);
            rightMin[i] = Math.min(rightMin[i + 1], currMin);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, leftMax[i] - rightMin[i + 1]);
            ans = Math.max(ans, rightMax[i + 1] - leftMin[i]);
        }

        return ans;
    }
}
