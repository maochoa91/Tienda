package com.example.tienda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ProductoViewHolder> {


    List<producto> productos;
    String URLImagen;
    Context context;
    public Adaptador(List<producto> productos) {
        this.productos = productos;
    }


    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview,viewGroup,false);
        ProductoViewHolder PVH=new ProductoViewHolder(view);
        return PVH;
    }

    @NotNull
    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder productoViewHolder, int i) {
        productoViewHolder.NombreProducto.setText(productos.get(i).NOMBRE);
       // Glide.with(context).load(URLImagen).into(productoViewHolder.ImagenProducto);
        productoViewHolder.ImagenProducto.setImageResource(productos.get(i).Imgid);
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
        CardView cardView;
        TextView NombreProducto;
        ImageView ImagenProducto;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.Card);
            NombreProducto=(TextView)itemView.findViewById(R.id.t1Card);
            ImagenProducto=(ImageView)itemView.findViewById(R.id.imgCard);
        }

    }

}
