package com.san.graphs;

import java.util.*;

public class Graph {

    class Vertex {
        String label;
        boolean isVisited;
    }

    Map<String,Vertex> vertices = new HashMap<>();
    Map<Vertex, Set<Vertex>> graph = new HashMap<>();


    public void addVertex(String label) {
        Vertex v = new Vertex();
        v.label=label;
        v.isVisited=false;

        vertices.put(label,v);
        graph.put(v,new HashSet<>());
    }

    public void addEdge(String label1, String label2) {

        Vertex v1 = vertices.get(label1);
        Vertex v2 = vertices.get(label2);

        Set<Vertex> v1edges = graph.get(v1);
        v1edges.add(v2);

        //for single directional graph don't do this
        Set<Vertex> v2edges = graph.get(v2);
        v2edges.add(v1);
    }

    public void addDirectionalEdge(String label1, String label2) {

        Vertex v1 = vertices.get(label1);
        Vertex v2 = vertices.get(label2);

        Set<Vertex> v1edges = graph.get(v1);
        v1edges.add(v2);
    }


    public void depthFirstSearch(String label) {

        Stack<Vertex> stack = new Stack<>();

        Vertex root = vertices.get(label);
        stack.push(root);

        while( ! stack.isEmpty()) {
            Vertex current = stack.pop();
            Set<Vertex> adjacentVertices = graph.get(current);

            for(Vertex v : adjacentVertices) {
                if( ! v.isVisited) {
                    stack.push(v);
                }
            }

            System.out.println(current.label);
            current.isVisited=true;
        }
    }

    public void breadthFirstSearch(String label) {
        Queue<Vertex> queue = new LinkedList<>();

        Vertex root = vertices.get(label);
        queue.add(root);

        while( ! queue.isEmpty()) {
            Vertex current = queue.remove();
            Set<Vertex> adjacentVertices = graph.get(current);

            for(Vertex v : adjacentVertices) {
                if( ! v.isVisited) {
                    queue.add(v);
                }
            }

            System.out.println(current.label);
            current.isVisited=true;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        graph.addDirectionalEdge("d","a");
        graph.addEdge("b","f");
        graph.addEdge("d","b");
        graph.addEdge("a","f");
        graph.addEdge("c","d");

        graph.depthFirstSearch("d");
    }

}
