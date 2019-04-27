package com.san.moderate;

public class LineIntersections {

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x= x;
            this.y=y;
        }
    }

    class Line {
        Coordinate c1;
        Coordinate c2;
        int m; //slope
        int b; //y coefficient

        public Line(Coordinate c1, Coordinate c2) {
            this.c1 = c1;
            this.c2 = c2;

            this.m = (c2.y-c1.y)/(c2.x-c1.x);
            this.b = c1.y - (this.m*c1.x);
        }
    }


    public Coordinate intersection(Line l1, Line l2) {

        //return null if parallel lines i.e. l1.m == l2.m

        Coordinate coordinate = new Coordinate(0,0);
        coordinate.x = (l2.b - l1.b) / (l2.m - l1.m);
        coordinate.y = (l1.m*coordinate.x) + (l1.b);

        //check if x,y are in range within l1 & l2

        return coordinate;
    }
}
