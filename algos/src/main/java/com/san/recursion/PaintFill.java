package com.san.recursion;

import java.util.Arrays;

public class PaintFill {

    public void paintFill(int[][] arr, int x, int y, int prevcolor, int newcolor,int rowmax, int colmax) {

        //out of bounds
        if((x>=rowmax) || (y>=colmax) || (x<0) || (y<0))
            return;

        //not prev color so don't care
        if(arr[x][y] != prevcolor)
            return;

        arr[x][y] = newcolor;

        paintFill(arr, x - 1, y, prevcolor, newcolor, rowmax, colmax);
        paintFill(arr, x + 1, y, prevcolor, newcolor, rowmax, colmax);
        paintFill(arr, x, y - 1, prevcolor, newcolor, rowmax, colmax);
        paintFill(arr, x, y + 1, prevcolor, newcolor, rowmax, colmax);

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1,1,1,1},
                {1,1,2,2,1,1},
                {1,1,2,2,1,1},
                {2,2,2,2,2,2}
        };

        new PaintFill().paintFill(arr,2,2,2,9,4,6);

        System.out.println(Arrays.deepToString(arr));
    }
}
