package com.google.android.gms.samples.vision.face.facetracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;

public class Bienvenida extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        ImageButton btn = (ImageButton)findViewById(R.id.imageButton2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inicio.class);
                startActivityForResult(intent, 0);
            }
        });

    }

}
