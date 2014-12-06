package com.example.asus.pharmaproche;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by ameni on 07/11/14.
 */
public class Store_Location {
    private static final LatLng MYSFAX = new LatLng(34.741310, 10.758319);
    GoogleMap map;
    ArrayList<Location> locations = new ArrayList<Location>();

    public Store_Location(GoogleMap map, ArrayList<Location> locations) {
        this.map = map;
        this.locations = locations;
    }

    public void DrawMarkers(android.location.Location mylocation) {


        Date date = new Date();
        int i = 0;
        int hour = date.getHours();

        for (i = 0; i < locations.size(); i++) {
            if (hour >= 8 && hour < 17) {
                if ("jour".equalsIgnoreCase(locations.get(i).type)) {
                    if (Math.abs(locations.get(i).getLat() - mylocation.getLatitude()) < 0.14 && Math.abs(locations.get(i).getLng() - mylocation.getLongitude()) < 0.14) {
                        map.addMarker(new MarkerOptions().position(
                                new LatLng(locations.get(i).getLat(),
                                        locations.get(i).getLng()))
                                .title(locations.get(i).getName())
                                .snippet(locations.get(i).getAdresse())
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                    }

                }
            } else {
                if (hour >= 17 && hour <= 20) {
                    if ("jour".equalsIgnoreCase(locations.get(i).type) && locations.get(i).isGarde()) {
                        if (Math.abs(locations.get(i).getLat() - mylocation.getLatitude()) < 0.03 && Math.abs(locations.get(i).getLng() - mylocation.getLongitude()) < 0.03) {
                            map.addMarker(new MarkerOptions().position(
                                    new LatLng(locations.get(i).getLat(),
                                            locations.get(i).getLng()))
                                    .title(locations.get(i).getName())
                                    .snippet(locations.get(i).getAdresse())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        }

                    }
                } else {
                    if ("nuit".equalsIgnoreCase(locations.get(i).type)) {
                        if ((Math.abs(locations.get(i).getLat() - mylocation.getLatitude()) < 0.06) && (Math.abs(locations.get(i).getLng() - mylocation.getLongitude()) < 0.06)) {
                            map.addMarker(new MarkerOptions().position(
                                    new LatLng(locations.get(i).getLat(),
                                            locations.get(i).getLng()))
                                    .title(locations.get(i).getName())
                                    .snippet(locations.get(i).getAdresse())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                        }

                    }

                }
            }

        }
    }
}
