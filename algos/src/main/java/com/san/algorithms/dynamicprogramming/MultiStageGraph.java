package com.san.algorithms.dynamicprogramming;

import sun.java2d.xr.MutableInteger;

import java.util.*;

public class MultiStageGraph {

    class Vertex {
        Integer ch;
        public Vertex(Integer ch) {
            this.ch= ch;
        }
    }

    class Edge {
        Vertex v1;
        Vertex v2;
        
        public Edge(Vertex v1, Vertex v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }
    
    class Cost {
        Integer totalcosttodest;
        Vertex via;
        Vertex source;
    }


    Map<Integer,Vertex> vertices = new HashMap<>();
    Map<Vertex, Set<Vertex>> graph = new HashMap<>();
    Map<Edge, Integer> edges = new HashMap<>();


    public void calculateShortestPathFromSourceToSink() {

        Map<Vertex,Cost> costMap = new HashMap<>();
        
        
        for(int i=7;i>=1;i--) {
            Vertex source = vertices.get(i);
            
            for(int j=i+1;j<=8;j++) {
                Vertex destination = vertices.get(j);
                
                //Set<Edge> edges =
            }
            //graph.get(v);
        }
    }


    public void go() {

        for(int i=1;i<=8;i++)
            vertices.put(i,new Vertex(i));

        Set<Vertex> set = graph.getOrDefault(vertices.get(1),new HashSet<>());
        set.add(vertices.get(2));
        set.add(vertices.get(3));
        set.add(vertices.get(4));
        graph.put(vertices.get(1),set);

        set = graph.getOrDefault(vertices.get(2),new HashSet<>());
        set.add(vertices.get(5));
        set.add(vertices.get(6));
        graph.put(vertices.get(2),set);

        set = graph.getOrDefault(vertices.get(3),new HashSet<>());
        set.add(vertices.get(5));
        set.add(vertices.get(6));
        graph.put(vertices.get(3),set);

        set = graph.getOrDefault(vertices.get(4),new HashSet<>());
        set.add(vertices.get(5));
        set.add(vertices.get(6));
        set.add(vertices.get(7));
        graph.put(vertices.get(4),set);

        set = graph.getOrDefault(vertices.get(5),new HashSet<>());
        set.add(vertices.get(8));
        graph.put(vertices.get(5),set);

        set = graph.getOrDefault(vertices.get(6),new HashSet<>());
        set.add(vertices.get(8));
        graph.put(vertices.get(6),set);

        set = graph.getOrDefault(vertices.get(7),new HashSet<>());
        set.add(vertices.get(8));
        graph.put(vertices.get(7),set);

        edges.put(new Edge(vertices.get(1),vertices.get(2)),2);
        edges.put(new Edge(vertices.get(1),vertices.get(3)),1);
        edges.put(new Edge(vertices.get(1),vertices.get(4)),3);
        edges.put(new Edge(vertices.get(2),vertices.get(5)),2);
        edges.put(new Edge(vertices.get(2),vertices.get(6)),3);
        edges.put(new Edge(vertices.get(3),vertices.get(5)),6);
        edges.put(new Edge(vertices.get(3),vertices.get(6)),7);
        edges.put(new Edge(vertices.get(1),vertices.get(2)),2);
        edges.put(new Edge(vertices.get(4),vertices.get(5)),6);
        edges.put(new Edge(vertices.get(4),vertices.get(6)),8);
        edges.put(new Edge(vertices.get(4),vertices.get(7)),9);
        edges.put(new Edge(vertices.get(5),vertices.get(8)),6);
        edges.put(new Edge(vertices.get(6),vertices.get(8)),4);
        edges.put(new Edge(vertices.get(7),vertices.get(8)),5);
    }

    public static void main(String[] args) {

        new MultiStageGraph().go();
    }
}


