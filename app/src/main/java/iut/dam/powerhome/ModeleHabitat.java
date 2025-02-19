package iut.dam.powerhome;

import java.util.ArrayList;

public class ModeleHabitat {
    String nom_habitat;
    boolean[] equipement;

    int etage;



    public ModeleHabitat(String nom_habitat, boolean[] equipement, int etage ) {
        this.nom_habitat = nom_habitat;
        this.equipement = equipement;
        this.etage = etage;
    }

    public String getNom_habitat() {
        return nom_habitat;
    }



    public int getEtage() {
        return etage;
    }

    public boolean[] getEquipementBoolean() {
        return equipement;
    }
}
