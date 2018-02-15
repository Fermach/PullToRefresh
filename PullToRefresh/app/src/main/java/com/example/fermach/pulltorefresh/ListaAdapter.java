package com.example.fermach.pulltorefresh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Fermach on 15/02/2018.
 */

public class ListaAdapter extends ArrayAdapter<Asignatura> {

    private int color;

    /**
     * Inicializamos el adptador
     * @param context
     * @param asignaturas
     * @param color
     */
    public ListaAdapter(@NonNull Context context, List<Asignatura> asignaturas, int color ) {

        super(context, 0,asignaturas);
        this.color=color;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Asignatura rutina= getItem(position);


        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        CardView cardView= convertView.findViewById(R.id.cardview);
        TextView nombre = convertView.findViewById(R.id.nombre_asi);
        TextView profesor = convertView.findViewById(R.id.nombre_prof);

        nombre.setText("Nombre: "+ rutina.getNombre());
        profesor.setText("Profesor: "+rutina.getProfesor());

        // seteamos el fondo de nuestros cardviews con el color que le hemos
        // pasado al adaptador
        cardView.setCardBackgroundColor(color);


        return convertView;
    }
}