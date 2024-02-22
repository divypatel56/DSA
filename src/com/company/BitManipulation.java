package com.company;

import java.util.Scanner;

public class BitManipulation {

    public static void main(String[] args) {
        // Get bit
        // 1. get bitmask = 1<<i(position we want)
        // 2. perform & operation

        int n=5; //0101
        int position=2;

        //1. bit mask
        int bitMask= 1<<position;
        if((n & bitMask)==0){
           System.out.println("Bit was 0");
        }
        else{
           System.out.println("Bit was 1");
        }

        // Set bit : make bit 1
        // step 1 bit mask 1<<i || step 2 perform OR |
        int newNum = n | bitMask;
        System.out.println(newNum);

        //Clear bit : make bit 0
        // Step 1 find not ~(bitmask)  step 2 perform And

        int notBitmask = ~(bitMask);
        System.out.println(notBitmask & n);

        /** Update bit : if bit=1 --> 0 || if bit=0 --> 1
        // for 1 --> 0(clear)  i) bitmask 1<<i
        //                     ii) perform And not

        // for 0 --> 1(set)  i) bitmask << i
        //                   ii) perform OR

         **/

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the Operation");
//        //if operation = 1 --> 0 || if operation = 0 -->1
//        // for noe the n is 0101 and position is 2
//
//        int ops = sc.nextInt();
//        if(ops == 1){
//            //set
//
//            int newNum = n | bitMask;
//            System.out.println(newNum);
//        }
//        else{
//            //clear
//            int notBitmask = ~(bitMask);
//            System.out.println(notBitmask & n);
//        }
    }
}
