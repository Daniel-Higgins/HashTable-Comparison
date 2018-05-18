/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc365a3.spanningTree;

/**
 *
 * @author danielhiggins
 */
import java.util.*;

public class Vertex implements Comparable<Vertex> {

    public final String name;
    public ArrayList<Edge> neighbours;
    public LinkedList<Vertex> path;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

    public Vertex(String name) {
        this.name = name;
        neighbours = new ArrayList<>();
        path = new LinkedList<>();
    }

    public String nameNam() {
        return name;
    }
}
