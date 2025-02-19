package iut.dam.powerhome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapteurHabitat extends RecyclerView.Adapter<AdapteurHabitat.MyViewHolder> {

    int[] ImageEquipements = {
            R.mipmap.machine_a_laver,R.mipmap.aspirateur,
            R.mipmap.climatiseur,R.mipmap.fer_a_repasser
    };
    Context context;

    ArrayList<ModeleHabitat> modeleHabitats;

    public AdapteurHabitat(Context context, ArrayList<ModeleHabitat> modeleHabitats) {
        this.context = context;
        this.modeleHabitats = modeleHabitats;
    }

    @NonNull
    @Override
    public AdapteurHabitat.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inlater = LayoutInflater.from(context);
        View view = inlater.inflate(R.layout.modelehabitat, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapteurHabitat.MyViewHolder holder, int position) {

        holder.image1.setVisibility(View.GONE);
        holder.image2.setVisibility(View.GONE);
        holder.image3.setVisibility(View.GONE);
        holder.image4.setVisibility(View.GONE);


        ImageView[] images = {holder.image1, holder.image2, holder.image3, holder.image4};
        int imageIndex = 0;


        boolean[] equipements = modeleHabitats.get(position).getEquipementBoolean();
        int NbEquipements = 0;

        for (int i = 0; i < equipements.length; i++) {
            if (equipements[i] && imageIndex < images.length) {
                images[imageIndex].setImageResource(ImageEquipements[i]);
                images[imageIndex].setVisibility(View.VISIBLE);
                imageIndex++;
                NbEquipements++;
            }
        }

        String message = (NbEquipements > 1) ? " équipements" : " équipement";
        holder.Nom_Habitat.setText(modeleHabitats.get(position).getNom_habitat());
        holder.NombreEquipement.setText(NbEquipements + message);
        holder.Etage.setText(String.valueOf(modeleHabitats.get(position).getEtage()));


    }

    @Override
    public int getItemCount() {
        return modeleHabitats.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image2, image3, image4, image1;

        TextView Nom_Habitat, NombreEquipement,Etage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
            image4 = itemView.findViewById(R.id.image4);
            image1 = itemView.findViewById(R.id.image1);
            Nom_Habitat = itemView.findViewById(R.id.Nom_haibitat);
            NombreEquipement = itemView.findViewById(R.id.NombreEquipement);
            Etage = itemView.findViewById(R.id.NumeroEtage);

        }

    }
}
