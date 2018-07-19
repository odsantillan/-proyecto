package com.google.android.gms.samples.vision.face.facetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.samples.vision.face.facetracker.io.ClientApiAdapter;
import com.google.android.gms.samples.vision.face.facetracker.model.clients;
import com.google.android.gms.samples.vision.face.facetracker.model.movies;
import com.google.android.gms.samples.vision.face.facetracker.ui.MovieFace.adapter.movieAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class peliculas extends AppCompatActivity implements Callback<ArrayList<movies>> {
    private movieAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);



        // Asociamos un adapter (ver más adelante cómo definirlo)


        //Call<ArrayList<movies>> call = ClientApiAdapter.getApiService().getMovies2(FaceTrackerActivity.nivelF);
        Call<ArrayList<movies>> call = ClientApiAdapter.getApiService().getMovies();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<movies>> call, Response<ArrayList<movies>> response) {
        if (response.isSuccessful()) {
            ArrayList<movies> Peliculas = response.body();
            Log.d("texto email", "Aqui> " +Peliculas.get(0).getPelicula()+ " tamano "+Peliculas.size()+" "+FaceTrackerActivity.nivelF);
           // mAdapter.setDataset(Peliculas);
            RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rvMovies);

            // Usar esta línea para mejorar el rendimiento
            // si sabemos que el contenido no va a afectar
            // el tamaño del RecyclerView
            mRecyclerView.setHasFixedSize(true);

            // Nuestro RecyclerView usará un grid layout manager
            GridLayoutManager layoutManager = new GridLayoutManager(this,1);
            mRecyclerView.setLayoutManager(layoutManager);
            movieAdapter mAdapter = new movieAdapter(Peliculas);
            mRecyclerView.setAdapter(mAdapter);

        }

    }

    @Override
    public void onFailure(Call<ArrayList<movies>> call, Throwable t) {

    }
}
