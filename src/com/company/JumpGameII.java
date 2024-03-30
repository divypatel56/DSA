class Solution {
    //TC =O(n) SC=O(1)
    public int jump(int[] nums) {
        // intialize the totaljump,
        int totalJump = 0;
        // destination,
        int destination = nums.length - 1;
        // lastJumpIndex, coverage
        int coverage = 0;
        int lastJumpindex = 0;

        // base case
        if (nums.length == 1)
            return 0;

         // greedy aproch: extend coverage as long as possible
        for (int i = 0; i < nums.length; i++) {
            // Update coverage
            coverage = Math.max(coverage, i + nums[i]);

            // If the current index reaches the last index jumped from
            if (i == lastJumpindex) {
                // Update last jump index to the current coverage
                lastJumpindex = coverage;
                // Increment total jumps
                totalJump++;

                // If the coverage reaches or exceeds the destination index
                if (coverage >= destination) {
                    // Return the total number of jumps
                    return totalJump;
                }
            }
        }
        // Return the total number of jumps
        return totalJump;
    }
}
