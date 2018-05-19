/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author danielhiggins
 */
public class Cluster {
    private ArrayList<HashTable> clusters;
    
    
    
    Cluster(ArrayList<HashTable> x){
        clusters = x;
    }
    HashTable clustData(HashTable x) throws Exception{
        ArrayList<Double> cos = new ArrayList<>();
        
        for(int i=0; i < clusters.size(); i++){
            Similarity s = new Similarity();
            double b = s.cosine(clusters.get(i), x);
            cos.add(b);
        }
        HashTable v = sort(cos);
        
        
        x.bdata.cluster = v.bdata.name;
        return x;
    }
    private HashTable sort(ArrayList<Double> d){
        double cos = 0;
        int cslistindex = 0;
        double temp;
        
        for(int i=0; i<d.size() - 1; i++){
            if(d.get(i) < d.get(i+1)){
                temp = d.get(i+1);
                if(temp > cos){
                    cos = temp;
                    cslistindex = i + 1;
                }
            }else if(d.get(i) > d.get(i+1)){
                temp = d.get(i);
                if(temp > cos){
                    cos = temp;
                    cslistindex = i;
                }
            }else{
                temp = d.get(i);
                if (temp > cos) {
                    cos = temp;
                    cslistindex = i;
                }
            }
        }
        return clusters.get(cslistindex);
    }
    
}

