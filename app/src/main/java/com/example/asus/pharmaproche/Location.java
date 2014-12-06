package com.example.asus.pharmaproche;

/**
 * Created by ameni on 07/11/14.
 */
public class Location {
    int id;
    double lat;
    double lng;
    String name;
    String adresse;
    String type;
    boolean garde;


    public Location(int id, double lat, double lng, String name, String adresse, String type, boolean garde) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.adresse = adresse;
        this.type = type;
        this.garde = garde;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGarde() {
        return garde;
    }

    public void setGarde(boolean garde) {
        this.garde = garde;
    }

    public Location(int id, double lat, double lng, String name) {
        this.id = id;
        this.name = name;

        this.lat = lat;

        this.lng = lng;

    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
