package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miras_lucas_projet_ecole_loustics.DB.User;
import com.example.miras_lucas_projet_ecole_loustics.R;

import java.util.List;

public class ListeEleveAdapter extends ArrayAdapter<User> {

    public ListeEleveAdapter(Context mCtx, List<User> userList){
        super(mCtx, R.layout.template_liste_eleve,userList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final User user = getItem(position);

        // charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_liste_eleve,parent,false);

        //Récupération des objets graphiques dans le template
        TextView textNom = (TextView) rowView.findViewById(R.id.textNom);
        TextView textPrenom = (TextView) rowView.findViewById(R.id.textPrenom);
        ImageView spritemp = rowView.findViewById(R.id.head);

        textNom.setText(user.getNom());
        textPrenom.setText(user.getPrenom());

        if (user.getNom().matches("Cartman")){
            spritemp.setImageResource(R.drawable.head_cartman);
        } else if (user.getNom().matches( "Stotch")){
            spritemp.setImageResource(R.drawable.butters_head);

        }else {
            spritemp.setImageResource(R.drawable.world_icon);
        }

        return rowView;
    }
}
