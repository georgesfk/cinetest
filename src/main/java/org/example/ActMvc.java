package org.example;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import org.example.controleur.ActeurControleur;
import org.example.model.Acteur;
import org.example.model.ActeurDAO;

import java.sql.*;
import java.util.List;

import static org.example.MySQLExample.connection;
//public  class MySQLExample2 {
public class ActMvc {
    public static void main(String[] args) {
        ActeurControleur ac = new ActeurControleur();
        ActeurDAO acteurDAO = new ActeurDAO();


        List<Acteur> acteurs = acteurDAO.getActeurs();
        for (Acteur act : acteurs) {
            ac.addActeur(act);
        }
        ac.afficheActeurs();
       ac.afficheActeur(2);
   //    acteurDAO.insertActeur(new Acteur("Brando","Marlon","brando.jpg"));
//        Acteur act = new Acteur() ;
//        act = ActeurDAO.insertActeur(2);
//        System.out.println(act.getNom());

    }

    private static void insertActeur() {
    }
}

