package com.san.algorithms.greedy;

import com.san.sets.DisjointSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrimsMinimumCostSpanningTree {

    class Vertex {
        Character label;

        public Vertex(Character label) {
            this.label = label;
        }
    }

    class Edge {
        Vertex v;
        Integer weight;

        public Edge(Vertex v, Integer weight) {
            this.v= v;
            this.weight=weight;
        }
    }

    Map<Character, Vertex> vertices = new HashMap<>();
    Map<Vertex, Set<Edge>> edges = new HashMap<>();


    public void addVertex(Character ch) {
        Vertex v = new Vertex(ch);
        vertices.put(ch, v);
    }

    public void addEdge(Character ch1, Character ch2, int weight) {
        Vertex v1 = vertices.get(ch1);
        Vertex v2 = vertices.get(ch2);

        Set<Edge> v1edges = edges.getOrDefault(v1, new HashSet<>());
        v1edges.add(new Edge(v2,weight));
        edges.put(v1,v1edges);

        Set<Edge> v2edges = edges.getOrDefault(v2, new HashSet<>());
        v2edges.add(new Edge(v1,weight));
        edges.put(v2,v2edges);
    }


    public Map<Vertex,Set<Edge>> getMinSpanningTree() {

        //find min edge
        return null;

    }
}
