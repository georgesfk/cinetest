package org.example.controleur;

import org.example.model.Acteur;
import org.example.view.ActeurView;

import java.util.ArrayList;
import java.util.List;

public class ActeurControleur {

    private List Acteurs;
    private ActeurView viewActeur;

    public ActeurControleur() {
            this.Acteurs = new ArrayList();
            this.viewActeur = new ActeurView();
    }

    public void addActeur(Acteur act) {
        Acteurs.add(act);
    }

    public void afficheActeurs () {
        viewActeur.afficheActeurs(Acteurs);
    }

    public void afficheActeur(int id) {
        System.out.println("ID:"+id);
        viewActeur.afficheActeur(Acteurs,id);
    }
}