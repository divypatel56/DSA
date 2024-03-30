class Solution {
    //Tc = O(n) Sc=O(1)
    public boolean canJump(int[] nums) {
        //Intialize the last index as a final destination.
        int finalDestination = nums.length - 1;

        //traverse backwards and update final destination accordingly
        for(int curr=finalDestination-1; curr>=0; curr--){
            //If we can reach to finaldestination from curr then
            //make finalDestination = curr 
            if(curr+nums[curr]>= finalDestination){
                finalDestination = curr;
            }
        }
        //Return true if at the end we rech to stating index and also the 
        // finalDestination is a starting index.
        return finalDestination==0;
        
    }
}
