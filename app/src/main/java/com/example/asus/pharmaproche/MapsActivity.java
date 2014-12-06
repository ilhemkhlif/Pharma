package com.example.asus.pharmaproche;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.*;
import com.google.android.gms.maps.*;
import android.location.LocationListener;
import android.location.LocationManager;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static final LatLng SFAX = new LatLng(34.73, 10.75);
    private Store_Location markers;
    ArrayList<com.example.asus.pharmaproche.Location> locations=new ArrayList<com.example.asus.pharmaproche.Location>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        locations.add(0,new com.example.asus.pharmaproche.Location(1,34.797962,10.760661,"Firas Elloumi","Route de Tunis","jour",false));
        locations.add(1,new com.example.asus.pharmaproche.Location(2,34.767451,10.735589,"Pharmacie","Route Gremda","nuit",false));
        locations.add(2,new com.example.asus.pharmaproche.Location(3,34.814639,10.76182,"Samir EL KOTTI","Sakiet elzzit","jour",false));
        locations.add(3,new com.example.asus.pharmaproche.Location(4,34.717748,10.721707,"Pharmacie Taha MELLOULI","Cité Habib, 43 Route Mharza, Sfax, Tunisie ","jour",false));
        locations.add(4,new com.example.asus.pharmaproche.Location(5,34.751027,10.761322,"Malek Gargouri","Route de Tunis, Sfax","jour",false));
        locations.add(5,new com.example.asus.pharmaproche.Location(6,34.749854,10.761121,"Pharmacie de Nuit Hedia Riahi Ep. Mellouli","Route de Tunis, Sfax","nuit",false));
        locations.add(6,new com.example.asus.pharmaproche.Location (7,34.799834,10.76098,"MAALEJ NJAH Semia","Sakiet Ezziet Sfax, Tunisie ","jour",false));
        locations.add(7,new com.example.asus.pharmaproche.Location(8,34.75009,10.74977,"AbdelHamid SAHNOUN","Route de Gremda, Sfax ","jour",false));
        locations.add(8,new com.example.asus.pharmaproche.Location(9,34.747634,10.73868,"GHORBEL Abdessalem","Route Ain, Sfax, Tunisia ","jour",false));
        locations.add(9,new com.example.asus.pharmaproche.Location(10,34.741811,10.736738,"Hager MHIRI KHLIF","Route Manzel Chaker, Sfax, Tunisia","jour",false));
        locations.add(10,new com.example.asus.pharmaproche.Location(11,34.801607,10.7675649,"ABDELKARIM BOUKHRIS","Sakiet Eddaier, Tunisia","jour",false));
        locations.add(11,new com.example.asus.pharmaproche.Location(12,34.786488,10.7437469,"Ben Youssef Rachida Ep Ajroud","Route Teniour Km 5.5, Sfax, Tunisia","jour",false));
        locations.add(12,new com.example.asus.pharmaproche.Location(13,34.7600625,10.7111336,"Zouhair abid","Route Ain, Sfax, Tunisia","jour",false));
        locations.add(12,new com.example.asus.pharmaproche.Location(13,34.7259267,10.7049538,"Pharmacie Elmatar","Route ElMatar, Sfax, Tunisia","jour",false));
        locations.add(13,new com.example.asus.pharmaproche.Location(14,34.5308163,10.5299663,"Pharmacie Aly Ben Abdallah","Mahras, Sfax, Tunisia","jour",false));
        locations.add(14,new com.example.asus.pharmaproche.Location(15,34.7226077,10.7138773,"Pharmacie Hdiji","Route Mharza, Sfax, Tunisia","jour",false));
        locations.add(15,new com.example.asus.pharmaproche.Location(16,34.7257469,10.7136198,"Pharmacie Soukra","Route Soukra, Sfax, Tunisia","jour",false));




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


     //  DbConnexion db=new DbConnexion(this);
       // try {
      //     db.create();
      //  } catch (IOException e) {
     //       e.printStackTrace();
      // }
       // List<com.example.nouha.test.Location> locations=null;
        /*locations=db.getLocations();
        int i=0;
        for(i=0;i<locations.size();i++)
            mMap.addMarker(new MarkerOptions().position(new LatLng(locations.get(i).getLat(), locations.get(i).getLng())).title(locations.get(i).getName()));
*/
    }


    public void onResume(){
        super.onResume();
        setUpMapIfNeeded();
    }


    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link com.google.android.gms.maps.SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(android.os.Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
        mMap.setMyLocationEnabled(true);

    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        //final MapController control = view.getController();
       // service = new google.maps.places.PlacesService(map);
      //  service.nearbySearch(request, callback);
        /** Récupère le locationManager qui gère la localisation */
        LocationManager manager;
       manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
/** Test si le gps est activé ou non */
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            /** on lance notre activity (qui est une dialog) */
            Intent localIntent = new Intent(this, PermissionGPS.class);

            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(localIntent);


        }else {


        LocationListener listner = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {


                mMap.setMyLocationEnabled(true);
                markers=new Store_Location(mMap,locations);
                markers.DrawMarkers(location);
                mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude()))
                        .title("Vous êtes là")
                .visible(true));

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                3600000, 1000, listner);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(SFAX)      // Sets the center of the map to Mountain View
                .zoom(12)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.getCameraPosition();


    }

    }
}
