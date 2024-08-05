package com.company;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boat=0;

        int left = 0 , right = people.length - 1;
        while(left <= right){
            if( people[left] + people[right] <= limit){
                left ++;
            }
            right--;
            boat++;
        }
        return boat;

    }
}

