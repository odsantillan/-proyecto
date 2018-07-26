package com.google.android.gms.samples.vision.face.facetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.samples.vision.face.facetracker.io.ClientApiAdapter;
import com.google.android.gms.samples.vision.face.facetracker.model.clients;
import com.google.android.gms.samples.vision.face.facetracker.model.movies;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registro extends AppCompatActivity implements Callback<ArrayList<clients>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final EditText tvname = (EditText)findViewById(R.id.editText4);
        final EditText tvlast = (EditText)findViewById(R.id.editText);
        final EditText tvemail = (EditText)findViewById(R.id.editText2);
        final EditText tvpass = (EditText)findViewById(R.id.editText3);

        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inicio.class);
                startActivityForResult(intent, 0);
                ClientApiAdapter.getApiService().setClients(tvname.getText().toString(),tvlast.getText().toString(),tvemail.getText().toString(),tvpass.getText().toString());
            }
        });


       // call.enqueue(this);

    }

    @Override
    public void onResponse(Call<ArrayList<clients>> call, Response<ArrayList<clients>> response) {

    }

    @Override
    public void onFailure(Call<ArrayList<clients>> call, Throwable t) {

    }
}
