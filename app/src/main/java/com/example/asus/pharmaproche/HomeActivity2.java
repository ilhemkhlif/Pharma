package com.example.asus.pharmaproche;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by khlif on 23/11/2014.
 */
public class HomeActivity2 extends Activity{

    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_now);

        Button BT = (Button) findViewById(R.id.buttonNear);
        final Context context = this;
        BT.setOnClickListener(new View.OnClickListener(){ public void onClick(View v) {
            startActivity(new Intent(context, MapsActivity.class));
        }});

}
}
