package com.company;

import java.util.HashSet;

public class TowerOfHanoi {
    //For q5
    public static int first = -1;
    public static int last = -1;

    // For q6
    public static boolean[] map = new boolean[26];
    /** Q1 Tower of Hanoi */
    public static void towerOfHanoi(int n, String src, String helper, String dest ){
        //base case
        if(n==1){
            System.out.println("transferring disk "+n+" from "+src+" to " + dest);
            return;
        }
        //step1 transfer n-1 disk to source
        // so here source is destination and destination is helper
        towerOfHanoi(n-1, src, dest,helper);
        //step2. transfer the src nth disk to destination
        System.out.println("transferring disk "+n+" from "+src+" to " + dest);
        //step3 transfer the n-1 disks from helper to destination use src as helper
        towerOfHanoi(n-1,helper,src,dest);
    }
    /** Q2 Reverse string */
    public static String reverseString(String str){
        if(str.isEmpty()){
            return str;
        }
        return(reverseString(str.substring(1))+str.charAt(0));
    }

    /** Q3: Find the first and last occurrence of element in string */
    public static void findOccurrence(String str,int index, char element){
        //Base case
        if( index == str.length()){
            System.out.println("First Occurrence: "+first);
            System.out.println("Last Occurrence: "+last);
            return;
        }
        char currentChar = str.charAt(index);

        if(currentChar == element){
            if(first == -1){
                first = index;
            }
            else{
                last = index;
            }
        }
        findOccurrence(str,index+1,element);
    }
    /** Q4 Check if an array is sorted(strictly increasing) */
    public static boolean isSorted(int[] arr, int index){
        if (index == arr.length-1){
            return  true;
        }
        if(arr[index] > arr[index+1]){

            return false;
        }
        //means array is sorted till now
        return isSorted(arr,index+1);
    }

    /**Q5 Move all x to end of the string */
    public static void moveX(String str,int index, int count, String newStr){
        if(index == str.length()) {
            for (int i = 0; i < count; i++) {
                newStr += 'x';
            }
            System.out.println(newStr);
           return;
        }

        char currentChar = str.charAt(index);
        if(currentChar == 'x'){
            count ++;
            moveX(str,index+1,count,newStr);
        }
        else{
            newStr += currentChar;
            moveX(str,index+1,count,newStr);
        }

    }

    /** Q6 Remove all the duplicate characters */
    public static void removeDuplicate(String str, int index,String newString){
        if(index == str.length()){
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(index);
        if(map[currentChar - 'a']) {
            removeDuplicate(str, index + 1, newString);
        }
        else{
            newString += currentChar;
            map[currentChar-'a'] = true;
            removeDuplicate(str,index+1,newString);
        }

    }

    /** Q7 Print all subsequence of the string */
    /** Q8 print unique subsequences add hashset */
    public static void printSubsequences(String str, int index, String newString, HashSet<String> set){
        if(index==str.length()){
            if(set.contains(newString)){
                return;
            }
            else {
                set.add(newString);
                System.out.println(newString);
                return;
            }
        }
        char currentChar = str.charAt(index);
        //char wants to be part of new subsequence
        printSubsequences(str,index+1,newString+currentChar, set);
        // char don't want to be part of new subsequence
        printSubsequences(str,index+1,newString,set);

    }


    public static void main(String[] args) {

        //to call tower of hanoi
        //int disks = 3;
        //towerOfHanoi(disks,"S","H","D");

        //System.out.println(reverseString("DCBA"));

        //findOccurrence("abaacdaefaah",0,'a');

        //int[] arr = {1,18,2,3,5};
        //System.out.println(isSorted(arr,0));
        //moveX("axbcxxde",0,0," ");

        //removeDuplicate("aaabccdd",0,"");

        HashSet<String> set = new HashSet<String>();

        printSubsequences("aabc",0,"",set);



    }
}
