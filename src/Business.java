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
public class Business implements java.io.Serializable {
 String id;
    String name;
    String state;
    String cluster = null;
    double latitude;
    double longitude;
    String[] closest = new String[4];
    
    public Business(String i, String n, String st, double lat, double lon) {
        id = i;
        name = n;
        state = st;
        latitude = lat;
        longitude = lon;
        
    }

    public String getName() {
        return name;
    }

    public String getBusId() {
        return id;
    }

    public String getState() {
        return state;
    }
    public double getLat(){
        return latitude;
    }
    public double getLong(){
        return longitude;
    }
    
}
