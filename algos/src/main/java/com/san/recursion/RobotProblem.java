package com.san.recursion;


//Imagine a robot sitting on the upper left hand corner of an NxN grid The robot can only move in two directions: right and down How many possible paths are there for the robot?
//FOLLOW UP
//Imagine certain squares are “off limits”, such that the robot can not step on them Design an algorithm to get all possible paths for the robot   O(square)
public class RobotProblem {

    public int countPaths(int grid[][], int row, int col, int[][] memo) {

        //base conditions
        //invalid path so return 0
        if(isNotAValidSquare(grid,row,col))
            return 0;

        //valid path so return 1
        if(iamAtEnd(grid,row,col))
            return 1;

        if(memo[row][col] == 0)
            memo[row][col] = countPaths(grid, row+1, col) + countPaths(grid, row, col+1);

        return memo[row][col];
    }

    public int countPaths(int grid[][], int row, int col) {

        //base conditions
        //invalid path so return 0
        if(isNotAValidSquare(grid,row,col))
            return 0;

        //valid path so return 1
        if(iamAtEnd(grid,row,col))
            return 1;

        return countPaths(grid, row+1, col) + countPaths(grid, row, col+1);
    }

    private boolean iamAtEnd(int[][] grid, int row, int col) {
        return row==2 && col==2;
    }

    private boolean isNotAValidSquare(int[][] grid, int row, int col) {
        return (row>2 || col>2) || (grid[row][col] == 1);
    }

    public static void main(String[] args) {

        RobotProblem robotProblem = new RobotProblem();
        int[][] grid = new int[3][3];


        System.out.println(robotProblem.countPaths(grid, 0,0));
    }
}
