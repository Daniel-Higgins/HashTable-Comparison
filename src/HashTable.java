/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author danielhiggins
 */
public class HashTable implements java.io.Serializable {

    int count;
    public Business bdata;
    LinkedList<Word>[] review;
    private final float threshold = 0.75f;
    //int maxSize = 24;

    public HashTable(Business d) {
        this.count = 0;
        this.review = new LinkedList[8];
        bdata = d;
    }
    
    
    

    void put(String k, Word w) {
        
        int hash = k.hashCode();
        int ahash = Math.abs(hash);
        int tableIndex = ahash & (review.length - 1);
        if (review[tableIndex] != null) {
            review[tableIndex].add(w);
            count++;

        } else {
            review[tableIndex] = new LinkedList<>();
            review[tableIndex].add(w);
            count++;

        }
        resize();

    }

    Word get(String a) {
        Word ret = null;
        int hash = a.hashCode();
        int ahash = Math.abs(hash);
        int tableIndex = ahash & (review.length - 1);
        for (int i = 0; i < review[tableIndex].size(); i++) {
            if (review[tableIndex].get(i).word.equals(a)) {
                ret = review[tableIndex].get(i);
                break;
            }
        }
        return ret;
    }

    public void resize() {

        int key = (int) (review.length * threshold);
        if (count >= key) {
            int newSize = review.length * 2;
            LinkedList<Word>[] newReview = new LinkedList[newSize];
            count = 0;        
            
            ArrayList<Word> list = getAll();
            review = newReview;
            for(Word w: list){
                put(w.word,w);
            }
           
        }

    }

    ArrayList<Word> getAll() {
        ArrayList<Word> entries = new ArrayList();
        for (int i = 0; i < review.length; i++) {
            if (review[i] != null) {
                for (int k = 0; k < review[i].size(); k++) {
                    if (review[i].get(k) != null) {
                        entries.add(review[i].get(k));
                    }
                }
            }
        }
        return entries;
    }

}
