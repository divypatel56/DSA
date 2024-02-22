package com.company;

import java.util.ArrayList;

public class Keypad {
    public static String[] keyPad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    /** Q1. Print all keypad combinations. */
    public static void KeyPad(String str, int index, String combination){
        if(index == str.length()){
            System.out.println(combination);
            return;

        }
        char currentChar = str.charAt(index);
        String mapping = keyPad[currentChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            KeyPad(str,index+1,combination+mapping.charAt(i));
        }
    }

    /** Q2. Print all permutation string */
    public static void printPermutation(String str, String Permutation){
        //Permutation starting with 'a':
        //
        //Remaining string: "bc"
        //Permutations of "bc": "bc", "cb"
        //Combined with 'a': "abc", "acb"
        if(str.length()==0){
            System.out.println(Permutation);
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newString = str.substring(0,i)+str.substring(i+1);
            printPermutation(newString,Permutation+currChar);
        }
    }

    /** Q3. Print total paths in maze to move from (i,j) to (n,m) */
    public static int countPaths(int i,int j, int n,int m){
        // out of cell
        if(i==n || j==m){
            return 0;
        }
        //only one path is possible
        if(i== n-1 && j==m-1){
            return 1;
        }

        //Count paths for curr(i,j)
        // move down + move right
        // count(i+1,j) + count(i,j+1)

        //move down
        int downPaths=countPaths(i+1,j,n,m);
        //move right
        int rightPaths= countPaths(i,j+1,n,m);
        return downPaths + rightPaths;

    }

    /** Q4 . Place e tiles of 1xm in floor of size nxm */
    public static int placeTiles(int n ,int m){
        //Base Case
         if(n==m){
             return  2;
         }
         if(n<m){
             return  1;

         }
        // Vertically place
        int placeVertical = placeTiles(n-m,m);
        //horizontally place
        int placeHorizontal = placeTiles(n-1,m);

        return placeVertical+placeHorizontal;

    }

    /** Q5. Find no of ways in which we can invite n people to your party. */
    public static int  callGuest(int n){
        //Logic we have 2 pairs single or pairs
        //base case
        if (n <= 1) {
            return 1;
        }
        //single way
        int singleWay = callGuest(n-1);
        //pairs
        int pairWay = (n-1)*callGuest(n-2);
        return  singleWay+pairWay;
    }

    /** Q6 Print all subset of n*/
    public static void subsetOf(int n,ArrayList<Integer> subset){
        if(n==0){
            printSubset(subset);
            return;

        }
        //if element added in subset
        subset.add(n);
        subsetOf(n-1,subset);

        //if don't want to add
        subset.remove(subset.size()-1);
        subsetOf(n-1,subset);

    }

    private static void printSubset(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //KeyPad("23",0,"");
        //printPermutation("abc","");
        //System.out.println(countPaths(0,0,3,3));
        //System.out.println(placeTiles(3,3));
        //System.out.println(callGuest(3));
        ArrayList<Integer> subset = new ArrayList<Integer>();
        subsetOf(3,subset);

    }
}
