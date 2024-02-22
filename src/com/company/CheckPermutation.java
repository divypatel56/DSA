package com.company;

import java.util.Arrays;

//Check Permutation: Given two strings, write a method to decide if one is a permutation of the
//other.
// A permutation of a string is another string with the same characters but possibly in a different order.
public class CheckPermutation {
    public static boolean isPermutation(String str1, String str2){
        if (str1.length() != str2.length()) {
            return false;
        }

        char str1Arry[] = str1.toCharArray();
        char str2Arry[] = str2.toCharArray();

        Arrays.sort(str1Arry);
        Arrays.sort(str2Arry);
        for (int i = 0; i < str1Arry.length ; i++) {
            if (str1Arry[i]!=str2Arry[i]){
               return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bce";


        System.out.println( isPermutation(str1,str2));

    }
}
