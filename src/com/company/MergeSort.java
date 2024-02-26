package com.company;

public class MergeSort {
    public static void conquer(int[] arr, int si,int mid,int ei ){
        int[] mergedArr = new int[ei-si+1];

        int idx1 = si; // to track first divided arr
        int idx2 = mid+1; // to track second divided arr
        int x=0; // to track mergedArr

        while(idx1<=mid && idx2<=ei){
            //compare the value of both arrays
            //and add the smaller one to merged array
            if(arr[idx1]<=arr[idx2]){
                mergedArr[x]= arr[idx1];
                x++;
                idx1++;
            }
            else{
                mergedArr[x]= arr[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1<=mid){
            mergedArr[x]= arr[idx1];
            x++;
            idx1++;

        }

        while(idx2<=ei){
            mergedArr[x] = arr[idx2];
            x++;
            idx2++;
        }

        //copy all sorted arr(mergedArr) to our original arr
        for(int i = 0, j = si; i <mergedArr.length; i++,j++) {
            arr[j] = mergedArr[i];
        }

    }
    public static void divide(int[] arr, int si, int ei ){ //si=starting index, ei=ending index
        //base case
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2; // (si+ei)/2 gives space problem
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);

    }

    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,3,8};
        int n = arr.length;
        divide(arr,0,n-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}
