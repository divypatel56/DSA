package com.company;
//Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?

import java.util.Arrays;

public class IsUnique {
    public static boolean isUnique(String str){
        if (str == null) {
            return false;
        }
        //1. convert string to array.
        char[] strArr = str.toCharArray();

        //2. sort array
        Arrays.sort(strArr);
        //3. compare char[i] and char[i+1]
        for (int i = 0; i < strArr.length-1; i++) {
            if(strArr[i]==strArr[i+1]){
                return false;
            }
            
        }
        return  true;
    }
    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "hello";

        System.out.println(isUnique(str1));
        System.out.println(isUnique(str2));

    }
}
