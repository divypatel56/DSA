import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Start backtracking with an empty tempList
        backtrace(nums, new ArrayList<Integer>(), result);
        return result; // Return the result list containing all permutations
    }

    private void backtrace(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> resultList) {
        // Base case: if tempList size equals nums length, add tempList to resultList
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<Integer>(tempList));
            return;
        }

        // Iterate through each number in nums array
        for (int num : nums) {
            // Check if num is already in tempList
            if (tempList.contains(num)) {
                continue; // Skip if num is already in tempList
            }

            tempList.add(num); // Add num to tempList

            // Recur with updated tempList
            backtrace(nums, tempList, resultList);

            tempList.remove(tempList.size() - 1); // Backtrack: Remove last element to explore other possibilities
        }
    }
}
