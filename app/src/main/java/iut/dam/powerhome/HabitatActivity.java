package iut.dam.powerhome;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HabitatActivity extends AppCompatActivity {


    ArrayList<ModeleHabitat> modeleHabitats = new ArrayList<>();

//    int[] ImageEquipements = {
//            R.drawable.baseline_arrow_back_24,R.drawable.email_1_svgrepo_com,
//            R.drawable.ic_launcher_background,R.drawable.icon_user
//    };
boolean[][] equipement = {
        {true, true, true, true},
        {true, false, false, false},
        {false, true, false, true},
        {true, true, false, true},
        {false, true, false, false}
};


    String[] NomHabitat = {
            "GAETAN LECLAIR", "CEDRIC BOUDET",
            "GAYLORD THIBODEAUX", "ADAM JACQUINOT",
            "ABEL FRESNEL"
    };

    int[] etage = {1,1,2,3,3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habitat);

        RecyclerView r = findViewById(R.id.ListeHabitat);
        setRecycleView();
        AdapteurHabitat adapteur = new AdapteurHabitat(this, modeleHabitats);
        r.setAdapter(adapteur);
        r.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));




    }
    private void setRecycleView() {
        for (int i = 0; i < NomHabitat.length; i++) {
                modeleHabitats.add(
                        new ModeleHabitat(NomHabitat[i], equipement[i],etage[i] ));

        }
    }

}
