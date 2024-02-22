package com.company;

public class Sorting {

    /** Bubble Sort */
    public static void bubbleSort(int[] arr){
        /** Time complexity = O(n^2) */
        // first loop run n-1
        // second loop n-1, n-2, n-3
        // in Big O we ignore constant values so the loops are running n^2 times.
        for (int i = 0; i <arr.length-1 ; i++) { //n-1
            for (int j = 0; j < arr.length-i-1 ; j++) { //n-1,n-2,n-3
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArr(arr);

    }

    /** Selection Sort
     * time complexity = O(n^2)*/

    /** Insertion sort */
    public  static void insertionSort(int[] arr){
        // unsorted part
        for (int i = 1; i < arr.length ; i++) {
            int curr = arr[i];
            //To track sort part
            int j = i-1;  //start = 0;

            while (j >= 0 && curr < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }

            //Placement
            arr[j+1] =curr;

        }
        printArr(arr);

    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        printArr(arr);
    }

    public static void printArr(int[] arr){

        for (int n:arr) {
            System.out.print(n+" ");
        }

    }
    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2};

        //bubbleSort(arr);
        //selectionSort(arr);
          insertionSort(arr);



    }
}
