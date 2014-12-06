package com.example.asus.pharmaproche;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by khlif on 23/11/2014.
 */
public class HomeActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button BT = (Button) findViewById(R.id.buttonNow);
        final Context context = this;
        BT.setOnClickListener(new View.OnClickListener(){ public void onClick(View v) {
            startActivity(new Intent(context, HomeActivity2.class));
        }});

    }





}
