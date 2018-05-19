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
public class Similarity implements java.io.Serializable{
    
    private HashTable searchreview;
    private double searchmagit;
    private HashTable basereview;
    private double basemagit;

    //cosine vector between 2 business ids
    double cosine(HashTable s, HashTable b) throws Exception {
        searchreview = s;
        basereview = b;
        double ab = numerator();
        searchmagit = magmake(searchreview);
        basemagit = magmake(basereview);
        double value = ab / (basemagit * searchmagit);
        //System.out.println("Cosine done for " + s.bdata.getBusId() + " and " + b.bdata.getBusId());
        return value;
    }
    
    //makes the denominator in the cosine similarity equation
    private double magmake(HashTable v) {
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Word> wo = v.getAll();
        for (int k = 0; k < wo.size(); k++) {
            t.add(wo.get(k).getCount());
        }
        double b = magitude(t);
        return b;
    }

    //magnitiude for the arraylist of how many wo are in hasht
    //number(getCount()) at index ^2
    private double magitude(ArrayList<Integer> a) {
        double count = 0;
        double finalc;
        for (int i = 0; i < a.size(); i++) {
            double k = a.get(i);
            count += Math.pow(k, 2);
        }
        
        

        finalc = Math.sqrt(count);
        return finalc;

    }

    //computates the A*B
    private double numerator() {

        ArrayList<String> setA = new ArrayList();
        ArrayList<String> setB = new ArrayList();
        ArrayList<String> union = new ArrayList();
        ArrayList<Word> search;
        ArrayList<Word> base;
        HashTable a = searchreview;
        HashTable b = basereview;
        double sum = 0;
        search = a.getAll();
        base = b.getAll();
        for (int i = 0; i < search.size(); i++) {
            String bet = search.get(i).word;
            union.add(bet);
            setA.add(bet);
        }
        for (int i = 0; i < base.size(); i++) {
            String bet = base.get(i).word;
            union.add(bet);
            setB.add(bet);
        }
        union.retainAll(setA);
        union.retainAll(setB);//gets all wo in a that are in b
        if (!union.isEmpty()) {
            for (int i = 0; i < union.size(); i++) {
                Word temp = a.get(union.get(i));
                Word tem = b.get(union.get(i));
                sum += ((temp.getCount()) * (tem.getCount()));
            }//mult count of word in both a and b together and adding to sum
        } else {

        }
        return sum;
    }
}

