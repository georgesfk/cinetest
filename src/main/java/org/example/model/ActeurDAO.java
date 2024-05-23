package org.example.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
//import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.sql.Connection;
import java.util.List;

public class ActeurDAO {
    Connection con = null;

    public List getActeurs() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Acteur> query =   session.createQuery("from Acteur" ,Acteur.class);
        List<Acteur> acteurs = query.getResultList();
        return (acteurs);
    }

    public Acteur getActeur(int id) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return (session.get(Acteur.class,id));
    }

    public void addActeur(Acteur act) {
        // insert query
        // using prepared statements
        PreparedStatement preparedStatement =null;
        try {
            String query = "INSERT INTO acteur (nom,prenom,photo) VALUES (?,?,?)";
            con.setAutoCommit(false);
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            pst.setString(1, act.getNom());
            pst.setString(2, act.getPhoto());
            pst.setString(3,act.getPhoto());

            pst.executeUpdate(); // executeUpdate is used for the insertion of the data
            con.commit();
            System.out.println("acteur ajouté!");
        } catch (Exception ex) {
            try {
                con.rollback();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }  finally {
           try {
               preparedStatement.close();
               con.close();
           } catch(Exception e) {}
        }
        }
    }
