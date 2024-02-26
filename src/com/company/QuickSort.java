package com.company;


public class QuickSort {
    // A utility function to swap two elements
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    public static int partition(int[] arr, int low, int high) {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low-1;

        for (int j = low; j <= high ; j++) {
            if (arr[j] < pivot) {
                // If current element is smaller than the pivot
                i++;
                //swap
                swap(arr,i,j);
            }
        }
        // to put pivot in it's right index
        // 6,3,5,2,9,8
        // swap 6,3,5,2,8,9
        swap(arr,i+1,high);
        //return pivot index
        return i+1;

    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public static void quickSort(int[] arr,int low, int high){
        if(low < high){
            // pivot is partitioning index, arr[p]
            // is now at right place
            int pivot = partition(arr,low,high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);

        }

    }



    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        int n = arr.length-1;

        quickSort(arr,0,n);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
