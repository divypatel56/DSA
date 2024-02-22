package com.company;

import java.util.HashMap;

public class MajorityElement {
    public static void majorityElement(int num[]){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int n = num.length;
        for (int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            }else {
                map.put(num[i], 1);
            }
        }
        for (int key: map.keySet()) {
            if (map.get(key) > n/3) {
                System.out.println(key);
            }

        }
    }
    public static void main(String[] args) {
        int nums[] = {1,3};
        majorityElement(nums);
    }
}
