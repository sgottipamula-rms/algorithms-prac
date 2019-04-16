package com.san.graphs;

import java.util.*;

public class FloodFill {

    class Vertex {
        int row;
        int col;

        public Vertex(int row, int col) {
            this.row=row;
            this.col=col;
        }
    }

    public void floodFill(int[][] image, int x, int y, int newcolor) {

        int prevcolor = image[x][y];
        Set<Vertex> isVisited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.add(new Vertex(x,y));

        while( ! stack.isEmpty()) {
            Vertex current = stack.pop();
            image[current.row][current.col] = newcolor;
            isVisited.add(current);

            List<Vertex> neighbours = getNeighbours(image, current, prevcolor);

            for(Vertex v : neighbours) {
                if (!isVisited.contains(v)) {
                    stack.push(v);
                }
            }
        }
    }

    private List<Vertex> getNeighbours(int[][] image,Vertex current, int prevcolor) {

        int r = current.row;
        int c = current.col;

        List<Vertex> neighbours = new ArrayList<>();

        //search all 8 neighbours around me to see if they have same color
        addNeighbour(image,neighbours,r-1,c-1, prevcolor);
        addNeighbour(image,neighbours,r-1,c, prevcolor);
        addNeighbour(image,neighbours,r-1,c+1, prevcolor);
        addNeighbour(image,neighbours,r,c-1, prevcolor);
        addNeighbour(image,neighbours,r,c+1, prevcolor);
        addNeighbour(image,neighbours,r-1,c+1, prevcolor);
        addNeighbour(image,neighbours,r+1,c, prevcolor);
        addNeighbour(image,neighbours,r+1,c+1, prevcolor);

        return neighbours;
    }

    public void addNeighbour(int[][] image, List<Vertex> neighbours, int r, int c, int prevcolor) {

        int maxRows = image.length;
        int maxCols = image[0].length;

        if(r<0 || r>=maxRows)
            return;

        if(c<0 || c>=maxCols)
            return;


        if(image[r][c] != prevcolor)
            return;

        neighbours.add(new Vertex(r,c));
    }


    public static void main(String[] args) {

        int[][] image = new int[][]
                {
                        {1,1,1,1,1,1},
                        {1,1,2,2,1,1},
                        {1,1,2,2,1,1},
                        {2,2,2,2,2,2}
                };

        new FloodFill().floodFill(image,2,2,5);

        System.out.println(Arrays.deepToString(image));
    }

}
