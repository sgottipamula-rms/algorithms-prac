package com.san.arrays;

public class GrowableGrid {

    int[][] grid;
    int maxsize;
    int negativeOffset;


    public GrowableGrid() {
        negativeOffset=2;
        maxsize=2;
        grid = new int[negativeOffset+maxsize][negativeOffset+maxsize];
    }


    public void add(int x, int y, int val) {
        accomodate(x);
        accomodate(y);
        grid[negativeOffset+x][negativeOffset+y] = val;
    }

    public int get(int x, int y) {
        return grid[negativeOffset+x][negativeOffset+y];
    }

    private void accomodate(int xy) {

        int coordinate = negativeOffset + xy;

        if(coordinate<0 || coordinate>(negativeOffset+maxsize)) {
            doubleGridSize();
        }
    }


    public void doubleGridSize() {
        int copy[][] = new int[(negativeOffset+maxsize)*2][(negativeOffset+maxsize)*2];

        int newoffset = negativeOffset*2;
        for(int i=0;i<maxsize;i++) {
            for(int j=0;j<maxsize;j++) {
                copy[newoffset+i][newoffset+j] = grid[negativeOffset+i][negativeOffset+j];
            }
        }

        negativeOffset=newoffset;
        grid = copy;
    }


    public static void main(String[] args) {
        GrowableGrid grid = new GrowableGrid();

        grid.add(1,1,10);
        grid.add(-3,-3,30);

        System.out.println(grid.get(1,1));
        System.out.println(grid.get(-3,-3));
    }
}
