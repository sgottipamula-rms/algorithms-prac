package com.san.graphs;

import java.util.*;

public class Graph {

    class Vertex {
        String label;
    }

    Map<String,Vertex> vertices = new HashMap<>();
    Map<Vertex, Set<Vertex>> adjacencyList = new HashMap<>();


    public void addVertex(String label) {
        Vertex v = new Vertex();
        v.label=label;

        vertices.put(label,v);
        adjacencyList.put(v,new HashSet<>());
    }

    public void addEdge(String label1, String label2) {

        Vertex v1 = vertices.get(label1);
        Vertex v2 = vertices.get(label2);

        Set<Vertex> v1Neighbours = adjacencyList.get(v1);
        v1Neighbours.add(v2);

        //for single directional adjacencyList don't do this
        Set<Vertex> v2Neighbours = adjacencyList.get(v2);
        v2Neighbours.add(v1);
    }

    public void addDirectionalEdge(String label1, String label2) {

        Vertex v1 = vertices.get(label1);
        Vertex v2 = vertices.get(label2);

        Set<Vertex> v1Neighbours = adjacencyList.get(v1);
        v1Neighbours.add(v2);
        adjacencyList.put(v1,v1Neighbours);
    }


    public void depthFirstSearch(String label) {

        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> isVisitedSet = new HashSet<>();

        Vertex root = vertices.get(label);
        stack.push(root);

        while( ! stack.isEmpty()) {
            Vertex current = stack.pop();
            Set<Vertex> adjacentVertices = adjacencyList.get(current);

            for(Vertex v : adjacentVertices) {
                if( ! isVisitedSet.contains(v)) {
                    stack.push(v);
                }
            }

            System.out.println(current.label);
            isVisitedSet.add(current);
        }
    }

    public void breadthFirstSearch(String label) {
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> isVisitedSet = new HashSet<>();

        Vertex root = vertices.get(label);
        queue.add(root);

        while( ! queue.isEmpty()) {
            Vertex current = queue.remove();
            Set<Vertex> adjacentVertices = adjacencyList.get(current);

            for(Vertex v : adjacentVertices) {
                if( ! isVisitedSet.contains(v)) {
                    queue.add(v);
                }
            }

            System.out.println(current.label);
            isVisitedSet.add(current);
        }
    }

    public void topologicalSort() {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> isVisitedSet = new HashSet<>();

        for(Vertex v : vertices.values()) {
            exploreVertex(v, stack, isVisitedSet);
        }

        while( ! stack.isEmpty())
            System.out.println(stack.pop().label);
    }

    public void exploreVertex(Vertex v, Stack<Vertex> stack, Set<Vertex> isVisitedSet) {

        if(v==null || isVisitedSet.contains(v))
            return;

        isVisitedSet.add(v);
        Set<Vertex> neighbours = adjacencyList.get(v);
        for(Vertex neighbour : neighbours) {
            exploreVertex(neighbour, stack, isVisitedSet);
        }

        stack.push(v);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        graph.addDirectionalEdge("a","d");
        graph.addDirectionalEdge("f","b");
        graph.addDirectionalEdge("b","d");
        graph.addDirectionalEdge("f","a");
        graph.addDirectionalEdge("d","c");

        //adjacencyList.depthFirstSearch("d");

        graph.topologicalSort();
    }

}
