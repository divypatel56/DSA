package com.company;
// For explanation of 2d arrays
// making 3x5 matrix
// and printing
// 1 2 3 4 5
// 6 7 8 9 10
// 1 3 4 5 6

import java.sql.SQLOutput;
import java.util.Scanner;

public class TwoDArrays {

    public static void main(String[] args) {
        System.out.println("Enter matrix size");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int col = sc.nextInt();
        int [][] matrix = new int[rows][col];

        System.out.println("Enter matrix row x column");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Your Entered Matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }





    }
}
