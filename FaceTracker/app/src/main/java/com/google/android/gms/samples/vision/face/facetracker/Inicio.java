package com.google.android.gms.samples.vision.face.facetracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.samples.vision.face.facetracker.io.ClientApiAdapter;
import com.google.android.gms.samples.vision.face.facetracker.model.clients;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inicio extends Activity implements Callback<ArrayList<clients>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);




        Call<ArrayList<clients>> call =ClientApiAdapter.getApiService().getClients();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<ArrayList<clients>> call, Response<ArrayList<clients>> response) {
        if (response.isSuccessful()){
            final ArrayList<clients> Clientes = response.body();

            final EditText etEmail = (EditText)findViewById(R.id.editTextEmail);
            final EditText etPass = (EditText)findViewById(R.id.editTextPass);
            ImageButton btn = (ImageButton)findViewById(R.id.imageButton4);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i=0,cont=0;
                    for (i=0; i < (Clientes.size()); i++) {
                        if ((Clientes.get(i).getEmail().equals(etEmail.getText().toString()))  && (Clientes.get(i).getPass().equals(etPass.getText().toString()))) {
                            Intent intent = new Intent(v.getContext(), FaceTrackerActivity.class);
                            startActivityForResult(intent, 0);
                            //etEmail.setText(a);
                            Log.d("texto email", "Aqui> " +""+ " tamano "+Clientes.size());
                            cont=i;
                            break;
                        }

                    }
                    if (!Clientes.get(cont).getEmail().equals(etEmail.getText().toString()) || !Clientes.get(i).getPass().equals(etPass.getText().toString()))  {
                        Toast.makeText(Inicio.this, "Email o contraseña incorrecta. Vuelve a intentarlo", Toast.LENGTH_SHORT).show();
                        Log.d("texto error", "Aqui> " + "" + " etEmail " + etEmail.getText().toString()+" Pass "+etPass.getText().toString()+" "+Clientes.get(1).getPass());
                    }

                }
            });



            Log.d("onResponse clients","Tamaño =>"+Clientes.size());
        }
    }

    @Override
    public void onFailure(Call<ArrayList<clients>> call, Throwable t) {
        Log.d("onFailure "," Causa"+t.getCause()+", Mensaje Localizado"+t.getLocalizedMessage()+", Mensaje"+t.getMessage());
    }
}
