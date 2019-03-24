package com.san.searching;

import java.util.Arrays;

public class MatrixSearch {

    public int[][] findElement(int[][] arr, int val) {

        int[][] result = new int[][]{
            {-1,-1}
        };


        int row = 0;
        int col = arr[0].length-1;

        while(true) {

            if(val == arr[row][col]) {
                result[0][0] = row;
                result[0][1] = col;
                break;
            }

            if(val<arr[row][col]) {
                col--;
                continue;
            }

            if(val>arr[row][col]) {
                row++;
                continue;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        MatrixSearch matrixSearch = new MatrixSearch();

        int[][]  arr  = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] res = matrixSearch.findElement(arr,8);
        System.out.println(Arrays.toString(res[0]));

    }
}
