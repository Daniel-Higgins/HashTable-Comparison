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
public class ReviewData implements java.io.Serializable{
    String id;
    String busid;
    String text;
    //business id
    public ReviewData(String ii, String bid, String t){
        id = ii;
        busid = bid;
        text = t;
    }
    
    public String getId(){
        return id;
    }
    
    public String getBusId(){
        return busid;
    }
    
    public String getReview(){
        return text;
    }
    
}
