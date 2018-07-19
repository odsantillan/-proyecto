package com.google.android.gms.samples.vision.face.facetracker.ui.MovieFace.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.samples.vision.face.facetracker.R;
import com.google.android.gms.samples.vision.face.facetracker.model.movies;

import java.util.ArrayList;

public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder> {
    private ArrayList<movies> mDataSet=new ArrayList<>();

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView nombre;
        public TextView director;
        public TextView descripcion;
        //public ImageView imagen;
        public ViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.nombrePelicula);
            director = (TextView) v.findViewById(R.id.directorPelicula);
            descripcion = (TextView) v.findViewById(R.id.descripcionPelicula);
            //ImageView ipeli = (ImageView) v.findViewById(R.id.nombrePelicula);

        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public movieAdapter(ArrayList<movies> dataSet)  {mDataSet = dataSet;}



    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public movieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.peliculasview, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings
        // ...

        return new ViewHolder(v);

    }

    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos

        holder.nombre.setText(mDataSet.get(i).getPelicula());
        holder.director.setText(mDataSet.get(i).getDirector());
        holder.descripcion.setText(mDataSet.get(i).getDescripcion());
        //holder.imagen.set.setText(mDataSet.get(position).getEnlace());


    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo en RecyclerViews que implementar filtros o búsquedas
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
