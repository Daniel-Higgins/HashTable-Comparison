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
public class Edge{
  public final Vertex target;
	public final double weight;
	public Edge(Vertex target, double weight){
		this.target = target;
		this.weight = weight;
	}
}