/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc365a3.spanningTree;

import java.util.*;
import csc365a3.GUI;
import csc365a3.HashTable;
/**
 *
 * @author danielhiggins
 */


public class Graph {
   
    /**
     *
     */
    
  private ArrayList<Vertex> vertices;
	public Graph(int numberVertices, ArrayList<HashTable> k){
		vertices = new ArrayList<>(numberVertices);
		for(int i=0;i <= numberVertices - 1;i++){
                        //System.out.println(k.get(i).bdata.getName());
			vertices.add(new Vertex(k.get(i).bdata.getName()));
		}
	}
	
	public void addEdge(int src, int dest, double weight){
		Vertex s = vertices.get(src);
		Edge new_edge = new Edge(vertices.get(dest),weight);
		s.neighbours.add(new_edge);
	}
	
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	
	public Vertex getVertex(int vert){
		return vertices.get(vert);
	}
}
