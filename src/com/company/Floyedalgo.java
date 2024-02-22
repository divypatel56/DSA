package com.company;

public class Floyedalgo {
    public static int findDuplicate(int[] nums) {
        int slow = 0 , fast = 0;
        //Move slow and fast until they meet
        do{
            slow = nums[slow]; // shift 1
            fast = nums[nums[fast]]; // shift 2
        }while(slow != fast);

        // As soon as they meet, start slow from beginig
        // and move both pointer at same speed until they meet again.
        // And when they meet return the value.
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("The duplicate num is: "+ findDuplicate(nums));

    }
}
