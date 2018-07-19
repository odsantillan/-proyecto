package com.google.android.gms.samples.vision.face.facetracker.io;

import com.google.android.gms.samples.vision.face.facetracker.io.response.ClientsResponse;
import com.google.android.gms.samples.vision.face.facetracker.model.clients;
import com.google.android.gms.samples.vision.face.facetracker.model.movies;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClientApiService {
    @GET("usuarios")
    Call<ArrayList<clients>> getClients();

   @GET("peliculas")
    Call<ArrayList<movies>> getMovies();

    @GET("peliculas/{?estado}")
    Call<ArrayList<movies>> getMovies2(
            @Path("estado") String estado);
}
