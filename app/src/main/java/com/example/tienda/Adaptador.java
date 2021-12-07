package com.example.tienda;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ProductoViewHolder> {


    List<producto> Productos;

    public Adaptador(List<producto> productos) {
        Productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder{

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
