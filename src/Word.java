/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc365a3;

/**
 *
 * @author danielhiggins
 */
public class Word implements java.io.Serializable{

    private double tfIdf;

    String word;
    int count;

    public Word(String w, int c) {
        word = w;
        count = c;

    }

    int getCount() {
        return count;
    }
    String getWord(){
        return word;
    }
    //term freq and inverse doc freq
    public double getTfIdf() {
        return tfIdf;
    }

    public void setTfIdf(double d) {
        tfIdf = d;
    }
}
